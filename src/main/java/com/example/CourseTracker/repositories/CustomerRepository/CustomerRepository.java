package com.example.CourseTracker.repositories.CustomerRepository;

import com.example.CourseTracker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>, CustomerRepositoryCustom {

    List<Customer> getAllCustomersForCourse(Long courseId);

    List<Customer> getAllCustomersFromTownOnCourse(String town, Long courseId);

    List<Customer> getAllCustomersOverAgeFromTownOnCourse(int age, String town, Long courseId);

}
