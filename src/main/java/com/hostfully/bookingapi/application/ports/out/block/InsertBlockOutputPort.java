package com.hostfully.bookingapi.application.ports.out.block;

import com.hostfully.bookingapi.application.core.domain.Block;

public interface InsertBlockOutputPort {

    Block insert(Block block);
}
