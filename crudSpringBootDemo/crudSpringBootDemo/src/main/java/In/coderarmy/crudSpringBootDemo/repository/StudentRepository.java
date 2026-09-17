package In.coderarmy.crudSpringBootDemo.repository;

import In.coderarmy.crudSpringBootDemo.entity.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;

@Repository
public class StudentRepository {
    public Student saveStudent(Student studentReq) {
        System.out.println("Inside Student Repository");
        System.out.println("Exiting Student Repository");
        Student s1 = new Student();
        s1.setName("Raghvendra");
        s1.setAge(20);
        s1.setEmail("raghvendra@gmail.com");
        s1.setRollNo(100);
        s1.setSubject("Spring Framework");

        return s1;

    }
}
