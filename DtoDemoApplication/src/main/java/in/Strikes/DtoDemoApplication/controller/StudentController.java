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

        CreateStudentResponseDto createdStudent = studentService.createStudent(studentRequestDto);
        /*return ResponseEntity.ok(createdStudent);*//*return ResponseEntity.status(201).body(createdStudent);*/
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(createdStudent);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudent(@PathVariable Long id){
        CreateStudentResponseDto studentResp = studentService.getStudent(id);

        return ResponseEntity.ok(studentResp);
    }
    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudent() {
        List<CreateStudentResponseDto> studentList = studentService.getAllStudent();


        return ResponseEntity.ok(studentList);
    }

    @PutMapping
    public ResponseEntity<UpdateStudentResponseDto> updateStudent(@RequestParam Long id,
                                                                  @RequestBody UpdateStudentRequestDto studentReq){
        UpdateStudentResponseDto studentResp = studentService.updateStudent(id, studentReq);


        return ResponseEntity.ok(studentResp);
    }



    @DeleteMapping
    public ResponseEntity<String> deleteStudent(@RequestParam Long id){
        studentService.deleteStudent(id);


        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/delete-soft")
    public ResponseEntity<String> deleteStudentSoftly(@RequestParam Long id){
        studentService.deleteStudentSoftly(id);

        return ResponseEntity.noContent().build();
    }

}

