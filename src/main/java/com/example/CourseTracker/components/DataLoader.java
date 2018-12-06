package com.example.CourseTracker.components;

import com.example.CourseTracker.models.Booking;
import com.example.CourseTracker.models.Course;
import com.example.CourseTracker.models.Customer;
import com.example.CourseTracker.repositories.BookingRepository.BookingRepository;
import com.example.CourseTracker.repositories.CourseRepository.CourseRepository;
import com.example.CourseTracker.repositories.CustomerRepository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Course java = new Course("intro to java", "edinburgh", 4);
        courseRepository.save(java);

        Course ruby = new Course("intro to ruby", "glasgow", 3);
        courseRepository.save(ruby);

        Customer steve = new Customer("steve", "linlithgow", 35);
        customerRepository.save(steve);

        Customer hetty = new Customer("hetty", "glasgow", 52);
        customerRepository.save(hetty);

        Booking booking1 = new Booking("13-06-18", java, steve);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-02-19", ruby, hetty);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01-02-19", ruby, steve);
        bookingRepository.save(booking3);
    }

}
