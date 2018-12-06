package com.example.CourseTracker.controllers;

import com.example.CourseTracker.models.Course;
import com.example.CourseTracker.models.Customer;
import com.example.CourseTracker.repositories.CourseRepository.CourseRepository;
import com.example.CourseTracker.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/customers")
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CourseRepository courseRepository;

    @GetMapping
    public List<Customer> getAllCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping(value = "/{id}/courses")
    public List<Course> getAllCoursesForCustomer(@PathVariable Long id) {
        return courseRepository.getAllCoursesForCustomer(id);
    }
}
