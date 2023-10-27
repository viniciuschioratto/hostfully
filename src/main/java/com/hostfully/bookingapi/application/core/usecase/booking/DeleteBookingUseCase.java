package com.hostfully.bookingapi.application.core.usecase.booking;

import com.hostfully.bookingapi.application.core.domain.Booking;
import com.hostfully.bookingapi.application.ports.in.booking.DeleteBookingInputPort;
import com.hostfully.bookingapi.application.ports.out.booking.DeleteBookingOutputPort;
import com.hostfully.bookingapi.application.ports.out.booking.FindBookingOutputPort;

import java.util.Optional;

public class DeleteBookingUseCase implements DeleteBookingInputPort {

    private final DeleteBookingOutputPort deleteBookingOutputPort;

    private final FindBookingOutputPort findBookingOutputPort;

    public DeleteBookingUseCase(DeleteBookingOutputPort deleteBookingOutputPort, FindBookingOutputPort findBookingOutputPort) {
        this.deleteBookingOutputPort = deleteBookingOutputPort;
        this.findBookingOutputPort = findBookingOutputPort;
    }

    @Override
    public void deleteById(String id) throws Exception {
        Optional<Booking> booking = findBookingOutputPort.findById(id);

        if (booking.isEmpty()) {
            throw new Exception("Booking does not exist");
        }

        deleteBookingOutputPort.deleteById(id);
    }
}
