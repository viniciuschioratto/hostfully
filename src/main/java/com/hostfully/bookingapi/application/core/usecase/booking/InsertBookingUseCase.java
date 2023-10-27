package com.hostfully.bookingapi.application.core.usecase.booking;

import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.core.domain.Booking;
import com.hostfully.bookingapi.application.ports.in.booking.InsertBookingInputPort;
import com.hostfully.bookingapi.application.ports.out.block.FindBlockOutputPort;
import com.hostfully.bookingapi.application.ports.out.booking.FindBookingOutputPort;
import com.hostfully.bookingapi.application.ports.out.booking.InsertBookingOutputPort;

import java.util.List;

public class InsertBookingUseCase implements InsertBookingInputPort {

    private final FindBlockOutputPort findBlockOutputPort;

    private final InsertBookingOutputPort insertBookingOutputPort;

    private final FindBookingOutputPort findBookingOutputPort;

    public InsertBookingUseCase(FindBlockOutputPort findBlockOutputPort, InsertBookingOutputPort insertBookingOutputPort, FindBookingOutputPort findBookingOutputPort) {
        this.findBlockOutputPort = findBlockOutputPort;
        this.insertBookingOutputPort = insertBookingOutputPort;
        this.findBookingOutputPort = findBookingOutputPort;
    }

    @Override
    public Booking insert(Booking booking) throws Exception {

        List<Block> blocks = findBlockOutputPort.findBlockByPropertyBetweenDate(booking.getPropertyId(), booking.getStartPeriod(), booking.getEndPeriod());
        List<Booking> bookingList = findBookingOutputPort.findBookingByPropertyBetweenDate(booking.getPropertyId(), booking.getStartPeriod(), booking.getEndPeriod());

        if (!blocks.isEmpty() || !bookingList.isEmpty()) {
            throw new Exception("The property is not available in this period.");
        }

        return insertBookingOutputPort.insert(booking);
    }
}
