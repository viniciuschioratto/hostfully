package com.hostfully.bookingapi.application.ports.in.block;

import com.hostfully.bookingapi.application.core.domain.Block;

public interface InsertBlockInputPort {

    Block insert(Block block);
}
