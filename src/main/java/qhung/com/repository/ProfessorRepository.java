package qhung.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import qhung.com.model.Professor;

public interface ProfessorRepository extends JpaRepository< Professor, String> {

}