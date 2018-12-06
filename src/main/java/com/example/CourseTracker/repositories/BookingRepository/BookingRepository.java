package com.example.CourseTracker.repositories.BookingRepository;

import com.example.CourseTracker.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>, BookingRepositoryCustom {

    List<Booking> getAllBookingsForDate(String date);
}
