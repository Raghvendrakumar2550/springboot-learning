package in.Strikes.servlet;

import in.Strikes.model.User;
import in.Strikes.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest request,
                       HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        // Check missing fields first
        if (idParam == null || name == null ||
                email == null || mobile == null) {

            response.setStatus(400);
            response.setContentType("application/json");

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"Some fields are missing\"\n" +
                            "}"
            );

            return;
        }

        Integer id = Integer.parseInt(idParam);

        User user = new User(id, name, email, mobile);

        User createdUser = userService.createUser(user);

        response.setStatus(201);
        response.setContentType("application/json");

        response.getWriter().write(
                "{\n" +
                        "    \"message\" : \"User Added successfully\"\n" +
                        "}"
        );
    }

    @Override
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        response.setContentType("application/json");

        // GET /users
        if (idParam == null) {

            List<User> users = userService.getAllUsers();

            response.setStatus(200);
            response.getWriter().write(usersToJson(users));

            return;
        }

        // GET /users?id=1
        Integer id = Integer.parseInt(idParam);

        User userResp = userService.getUserById(id);

        // User not found
        if (userResp == null) {

            response.setStatus(404);

            response.getWriter().write(
                    "{\n" +
                            "    \"message\" : \"User not found\"\n" +
                            "}"
            );

            return;
        }

        // User found
        response.setStatus(200);
        response.getWriter().write(userToJson(userResp));
    }

    @Override
    public void doPut(HttpServletRequest request,
                      HttpServletResponse response) {

    }

    @Override
    public void doDelete(HttpServletRequest request,
                         HttpServletResponse response) {

    }

    private String userToJson(User user) {

        return "{\n" +
                "    \"id\" : " + user.getId() + ",\n" +
                "    \"name\" : \"" + user.getName() + "\",\n" +
                "    \"email\" : \"" + user.getEmail() + "\",\n" +
                "    \"mobile\" : \"" + user.getMobile() + "\"\n" +
                "}";
    }

    private String usersToJson(List<User> users) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        for (int i = 0; i < users.size(); i++) {

            stringBuilder.append(userToJson(users.get(i)));

            if (i < users.size() - 1) {
                stringBuilder.append(",");
            }
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }
}