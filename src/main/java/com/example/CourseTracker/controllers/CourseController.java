package com.example.CourseTracker.controllers;

import com.example.CourseTracker.models.Course;
import com.example.CourseTracker.repositories.CourseRepository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getAllCoursesWithRating(@PathVariable int rating) {
        return courseRepository.getAllCoursesWithRating(rating);
    }

}
