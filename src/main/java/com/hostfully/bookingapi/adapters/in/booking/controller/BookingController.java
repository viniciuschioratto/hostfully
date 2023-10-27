package com.hostfully.bookingapi.adapters.in.booking.controller;

import com.hostfully.bookingapi.adapters.in.booking.controller.mapper.BookingMapperIn;
import com.hostfully.bookingapi.adapters.in.booking.controller.request.BookingRequest;
import com.hostfully.bookingapi.adapters.in.booking.controller.response.BookingResponse;
import com.hostfully.bookingapi.application.core.domain.Booking;
import com.hostfully.bookingapi.application.ports.in.booking.DeleteBookingInputPort;
import com.hostfully.bookingapi.application.ports.in.booking.InsertBookingInputPort;
import com.hostfully.bookingapi.application.ports.in.booking.UpdateBookingInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingMapperIn bookingMapperIn;

    @Autowired
    private InsertBookingInputPort InsertBookingInputPort;

    @Autowired
    private DeleteBookingInputPort deleteBookingInputPort;

    @Autowired
    private UpdateBookingInputPort updateBookingInputPort;

    @Operation(summary = "Create a new Booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking created with success.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BookingRequest.class
                            )
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Error to create a new Booking.", content = @Content),
    })
    @PostMapping
    public ResponseEntity<BookingResponse> insert(@Valid @RequestBody BookingRequest bookingRequest) throws Exception {

        Booking booking = InsertBookingInputPort.insert(bookingMapperIn.toBooking(bookingRequest));

        return ResponseEntity.ok().body(bookingMapperIn.toBookingResponse(booking));

    }

    @Operation(summary = "Update a Booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking updated with success.", content = {
                    @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = BookingRequest.class
                            )
                    )
            }),
            @ApiResponse(responseCode = "400", description = "Error to update a Booking.", content = @Content),
    })
    @PutMapping("/{id}")
    public ResponseEntity<BookingResponse> update(@PathVariable final String id, @Valid @RequestBody BookingRequest bookingRequest) throws Exception {

        Booking booking = updateBookingInputPort.update(id, bookingMapperIn.toBooking(bookingRequest));

        return ResponseEntity.ok().body(bookingMapperIn.toBookingResponse(booking));
    }

    @Operation(summary = "Delete a Booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Booking deleted with success."),
            @ApiResponse(responseCode = "400", description = "Error to delete a Booking."),
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable final String id) throws Exception {

        deleteBookingInputPort.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
