package com.hostfully.bookingapi.adapters.out.block.repository;

import com.hostfully.bookingapi.adapters.out.block.repository.entity.BlockEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BlockRepository extends JpaRepository<BlockEntity, Integer> {
    @Query(value = "SELECT b.* FROM Block b WHERE b.property_id = :propertyId AND ((b.start_period BETWEEN :startBooking AND :endBooking) OR (b.end_period BETWEEN :startBooking AND :endBooking))", nativeQuery = true)
    List<BlockEntity> findAllByPropertyIdAndBetweenDate(@Param("propertyId") Integer propertyId,
                                                        @Param("startBooking")LocalDate startBooking,
                                                        @Param("endBooking")LocalDate endBooking);
}