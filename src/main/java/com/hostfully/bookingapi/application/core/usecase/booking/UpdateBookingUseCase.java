package com.hostfully.bookingapi.application.core.usecase.booking;

import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.core.domain.Booking;
import com.hostfully.bookingapi.application.ports.in.booking.UpdateBookingInputPort;
import com.hostfully.bookingapi.application.ports.out.block.FindBlockOutputPort;
import com.hostfully.bookingapi.application.ports.out.booking.FindBookingOutputPort;
import com.hostfully.bookingapi.application.ports.out.booking.UpdateBookingOutputPort;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class UpdateBookingUseCase implements UpdateBookingInputPort {

    private final FindBookingOutputPort findBookingOutputPort;

    private final UpdateBookingOutputPort updateBookingOutputPort;

    private final FindBlockOutputPort findBlockOutputPort;

    public UpdateBookingUseCase(FindBookingOutputPort findBookingOutputPort, UpdateBookingOutputPort updateBookingOutputPort, FindBlockOutputPort findBlockOutputPort) {
        this.findBookingOutputPort = findBookingOutputPort;
        this.updateBookingOutputPort = updateBookingOutputPort;
        this.findBlockOutputPort = findBlockOutputPort;
    }

    @Override
    public Booking update(String id, Booking booking) throws Exception {
        Optional<Booking> currentBooking = findBookingOutputPort.findById(id);

        if (currentBooking.isEmpty()) {
            throw new Exception("Booking does not exist");
        }

        List<Block> blocks = findBlockOutputPort.findBlockByPropertyBetweenDate(booking.getPropertyId(), booking.getStartPeriod(), booking.getEndPeriod());
        List<Booking> bookingList = findBookingOutputPort.findBookingByPropertyBetweenDate(booking.getPropertyId(), booking.getStartPeriod(), booking.getEndPeriod());

        if (!blocks.isEmpty() || (!bookingList.isEmpty() && isBookingIdDifferent(id, bookingList))) {
            throw new Exception("The property is not available in this period.");
        }

        booking.setId(Integer.valueOf(id));

        return updateBookingOutputPort.update(booking);
    }

    private static boolean isBookingIdDifferent(String id, List<Booking> bookingList) {

        for (Booking booking: bookingList) {

            if (Objects.equals(booking.getId(), Integer.valueOf(id))) {
                return false;
            }

        }

        return true;
    }
}
