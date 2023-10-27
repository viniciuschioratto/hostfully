package com.hostfully.bookingapi.application.ports.in.block;

import com.hostfully.bookingapi.application.core.domain.Block;

public interface UpdateBlockInputPort {

    Block update(String id, Block block) throws Exception;
}
