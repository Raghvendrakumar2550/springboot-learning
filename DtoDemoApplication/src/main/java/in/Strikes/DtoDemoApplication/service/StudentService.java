package in.Strikes.DtoDemoApplication.service;

import in.Strikes.DtoDemoApplication.dto.CreateStudentRequestDto;
import in.Strikes.DtoDemoApplication.dto.CreateStudentResponseDto;
import in.Strikes.DtoDemoApplication.dto.UpdateStudentRequestDto;
import in.Strikes.DtoDemoApplication.dto.UpdateStudentResponseDto;
import in.Strikes.DtoDemoApplication.entity.Student;
import in.Strikes.DtoDemoApplication.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentRequestDto) {

        Student student = mapToEntity(studentRequestDto);
         Student studentResp = studentRepository.save(student);
         return mapToDto(studentResp);
    }

    public Student getStudent(Long id){
        Optional<Student> studentResp = studentRepository.findById(id);

        if(studentResp.isPresent()){
            return studentResp.get();
        }
        return null;
    }

    public List<Student> getAllStudent(){
        List<Student> studentList = studentRepository.findByDeletedIsFalse();
        return studentList;
    }

    public UpdateStudentResponseDto updateStudent(Long id, UpdateStudentRequestDto studentReq){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return null;
        }
        Student studentToSave = existingStudent.get();

        studentToSave.setName(studentReq.getName());
        studentToSave.setRollNo(studentReq.getRollNo());
        studentToSave.setSubject(studentReq.getSubject());
        studentToSave.setAge(studentReq.getAge());
        studentToSave.setDeleted(false);
        studentToSave.setUpdatedAt(LocalDateTime.now());

        Student saveStudent = studentRepository.save(studentToSave);

        return mapToUpdateDto(saveStudent);
    }

    public Boolean deleteStudent(Long id){
        Boolean isStudent = studentRepository.existsById(id);

        if(!isStudent){
            return false;
        }

        studentRepository.deleteById(id);
        return true;
    }

    public Boolean deleteStudentSoftly(Long id){
        Optional<Student> existingStudent = studentRepository.findByIdAndDeletedIsFalse(id);

        if(existingStudent.isEmpty()){
            return false;
        }
        Student studentToSave = existingStudent.get();
        studentToSave.setDeleted(true);
        studentRepository.save(studentToSave);

        return true;
    }

    private Student mapToEntity(CreateStudentRequestDto studentRequestDto){
        Student student = new Student();

        student.setName(studentRequestDto.getName());
        student.setAge(studentRequestDto.getAge());
        student.setEmail(studentRequestDto.getEmail());
        student.setRollNo(studentRequestDto.getRollNo());
        student.setSubject(studentRequestDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);
        return student;

    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student saved successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;

    }

    private UpdateStudentResponseDto mapToUpdateDto(Student student) {
        UpdateStudentResponseDto responseDto = new UpdateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setMessage("Student updated successfully");
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

}

