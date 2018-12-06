package com.example.CourseTracker.repositories;

import com.example.CourseTracker.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
