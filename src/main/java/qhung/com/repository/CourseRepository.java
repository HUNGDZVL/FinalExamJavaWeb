package qhung.com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qhung.com.model.Course;
import qhung.com.model.Professor;


public interface CourseRepository extends JpaRepository<Course, String> {
  
}