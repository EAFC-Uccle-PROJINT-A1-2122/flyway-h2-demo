package be.eafcuccle.projint.flywayh2demo;

import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Long> {
    
}
