package be.eafcuccle.projint.flywayh2demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest(showSql = true)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    public void findById() {
        Student createdStudent = new Student("Yassine", "Aarab");

        Long studentId = repository.save(createdStudent).getId();
        em.flush(); // Make sure the entity is actually saved to the database.
        Optional<Student> foundStudent = repository.findById(studentId);

        assertTrue(foundStudent.isPresent());
        assertEquals("Yassine", foundStudent.get().getFirstName());
    }
}
