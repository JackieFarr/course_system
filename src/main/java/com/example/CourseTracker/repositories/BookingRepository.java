package com.example.CourseTracker.repositories;

import com.example.CourseTracker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
