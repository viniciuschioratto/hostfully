package com.hostfully.bookingapi.application.core.usecase.block;

import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.in.block.InsertBlockInputPort;
import com.hostfully.bookingapi.application.ports.out.block.InsertBlockOutputPort;

public class InsertBlockUseCase implements InsertBlockInputPort {

    private final InsertBlockOutputPort insertBlockOutputPort;

    public InsertBlockUseCase(InsertBlockOutputPort insertBlockOutputPort) {
        this.insertBlockOutputPort = insertBlockOutputPort;
    }

    @Override
    public Block insert(Block block) {

        return insertBlockOutputPort.insert(block);
    }
}
