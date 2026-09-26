package in.Strikes.DtoDemoApplication.controller;

import in.Strikes.DtoDemoApplication.dto.CreateStudentRequestDto;
import in.Strikes.DtoDemoApplication.dto.CreateStudentResponseDto;
import in.Strikes.DtoDemoApplication.dto.UpdateStudentRequestDto;
import in.Strikes.DtoDemoApplication.dto.UpdateStudentResponseDto;
import in.Strikes.DtoDemoApplication.entity.Student;
import in.Strikes.DtoDemoApplication.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(
            @Valid @RequestBody CreateStudentRequestDto studentRequestDto){

        CreateStudentResponseDto createdStudent = studentService.createStudent(studentRequestDto);/*return ResponseEntity.ok(createdStudent);*//*return ResponseEntity.status(201).body(createdStudent);*/
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/get")
    public ResponseEntity<Student> getStudent(@RequestParam Long id){
        Student studentResp = studentService.getStudent(id);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> studentList = studentService.getAllStudent();

        if (studentList.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/update")
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,
                                                                  @RequestBody UpdateStudentRequestDto studentReq){
        UpdateStudentResponseDto studentResp = studentService.updateStudent(id, studentReq);

        if(studentResp == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(studentResp);
    }



    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudent(id);

        if(!isDeleted) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        Boolean isDeleted = studentService.deleteStudentSoftly(id);
        if(!isDeleted){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok("Record Deleted");
    }

}

