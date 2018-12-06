package com.example.CourseTracker.repositories.BookingRepository;

import com.example.CourseTracker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
