package com.hostfully.bookingapi.application.ports.in.block;

public interface DeleteBlockInputPort {

    void deleteById(String id) throws Exception;
}
