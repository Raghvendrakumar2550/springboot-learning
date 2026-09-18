package In.coderarmy.crudSpringBootDemo.repository;

import In.coderarmy.crudSpringBootDemo.entity.Student;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLOutput;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
