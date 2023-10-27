package com.hostfully.bookingapi.adapters.out.booking.repository;

import com.hostfully.bookingapi.adapters.out.booking.entity.BookingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<BookingEntity, Integer> {

    @Query(value = "SELECT b.* FROM Booking b WHERE b.property_id = :propertyId AND ((b.start_period BETWEEN :startBooking AND :endBooking) OR (b.end_period BETWEEN :startBooking AND :endBooking))", nativeQuery = true)
    List<BookingEntity> findAllByPropertyIdAndBetweenDate(@Param("propertyId") Integer propertyId,
                                                        @Param("startBooking")LocalDate startBooking,
                                                        @Param("endBooking")LocalDate endBooking);
}
