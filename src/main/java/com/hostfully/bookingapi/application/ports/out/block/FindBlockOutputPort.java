package com.hostfully.bookingapi.application.ports.out.block;

import com.hostfully.bookingapi.application.core.domain.Block;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FindBlockOutputPort {

    Optional<Block> findById(String id) throws Exception;

    List<Block> findBlockByPropertyBetweenDate(Integer propertyId, LocalDate startBookingPeriod, LocalDate endBookingPeriod);
}
