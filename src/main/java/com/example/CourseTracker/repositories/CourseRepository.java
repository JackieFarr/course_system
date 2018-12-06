package com.example.CourseTracker.repositories;

import com.example.CourseTracker.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
