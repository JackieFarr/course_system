package com.example.CourseTracker;

import com.example.CourseTracker.models.Booking;
import com.example.CourseTracker.models.Course;
import com.example.CourseTracker.models.Customer;
import com.example.CourseTracker.repositories.BookingRepository.BookingRepository;
import com.example.CourseTracker.repositories.CourseRepository.CourseRepository;
import com.example.CourseTracker.repositories.CustomerRepository.CustomerRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseTrackerApplicationTests {

	@Autowired
	CourseRepository courseRepository;

	@Autowired
	BookingRepository bookingRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canAddBookingToCourse(){
		Course course = new Course("Intro to Java", "edinburgh", 4);
		courseRepository.save(course);

		Customer customer = new Customer("Steve", "glasgow", 34);
		customerRepository.save(customer);

		Booking booking = new Booking("24-07-18", course, customer);
		bookingRepository.save(booking);

		course.addBooking(booking);
		courseRepository.save(course);
	}

	@Test
	public void canAddBookingToCustomer(){
		Course course = new Course("Intro to Java", "edinburgh", 4);
		courseRepository.save(course);

		Customer customer = new Customer("Steve", "glasgow", 34);
		customerRepository.save(customer);

		Booking booking = new Booking("24-07-18", course, customer);
		bookingRepository.save(booking);

		customer.addBooking(booking);
		customerRepository.save(customer);
	}

	@Test
	public void canGetAllCoursesWithRating4() {
		List<Course> results = courseRepository.getAllCoursesWithRating(4);
	}

	@Test
	public void canGetAllCustomersForCourseId1() {
		List<Customer> results = customerRepository.getAllCustomersForCourse(1L);
	}

	@Test
	public void canGetAllCoursesForCustomerId1() {
		List<Course> results = courseRepository.getAllCoursesForCustomer(1L);
	}

	@Test
	public void canGetAllBookingsForDate_13_06_18(){
		List<Booking> results = bookingRepository.getAllBookingsForDate("13-06-18");
	}

	@Test
	public void canGetAllCustomersFromLinlithgowOnRubyCourse() {
		List<Customer> results = customerRepository.getAllCustomersFromTownOnCourse("linlithgow", 2L);
	}

}
