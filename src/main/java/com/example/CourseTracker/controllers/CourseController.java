package com.example.CourseTracker.controllers;

import com.example.CourseTracker.models.CaseInsensitivePathMatcher;
import com.example.CourseTracker.models.Course;
import com.example.CourseTracker.models.Customer;
import com.example.CourseTracker.repositories.CourseRepository.CourseRepository;
import com.example.CourseTracker.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.PathMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.List;

@RestController
@RequestMapping(value = "/courses")
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    @GetMapping(value = "/rating/{rating}")
    public List<Course> getAllCoursesWithRating(@PathVariable int rating) {
        return courseRepository.getAllCoursesWithRating(rating);
    }

    @GetMapping(value = "/{id}/customers")
    public List<Customer> getAllCustomersForCourse(@PathVariable Long id){
        return customerRepository.getAllCustomersForCourse(id);
    }

    @GetMapping(value = "/{id}/customers/town/{town}")
    public List<Customer> getAllCustomersFromTownOnCourse(@PathVariable String town, @PathVariable Long id) {
        return customerRepository.getAllCustomersFromTownOnCourse(town, id);
    }

    @GetMapping(value = "/{id}/customers/town/{town}/age/{age}")
    public List<Customer> getAllCustomersOverAgeFromTownOnCourse(@PathVariable int age, @PathVariable String town, @PathVariable Long id){
        return customerRepository.getAllCustomersOverAgeFromTownOnCourse(age, town, id);
    }

}
