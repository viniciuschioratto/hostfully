package com.hostfully.bookingapi.application.core.usecase.block;

import com.hostfully.bookingapi.application.core.domain.Block;
import com.hostfully.bookingapi.application.ports.in.block.UpdateBlockInputPort;
import com.hostfully.bookingapi.application.ports.out.block.FindBlockOutputPort;
import com.hostfully.bookingapi.application.ports.out.block.UpdateBlockOutputPort;

import java.util.Optional;

public class UpdateBlockUseCase implements UpdateBlockInputPort {

    private final FindBlockOutputPort findBlockOutputPort;

    private final UpdateBlockOutputPort updateBlockOutputPort;

    public UpdateBlockUseCase(FindBlockOutputPort findBlockOutputPort, UpdateBlockOutputPort updateBlockOutputPort) {
        this.findBlockOutputPort = findBlockOutputPort;
        this.updateBlockOutputPort = updateBlockOutputPort;
    }

    @Override
    public Block update(String id, Block block) throws Exception {

        Optional<Block> currentBlock = findBlockOutputPort.findById(id);

        if (currentBlock.isEmpty()) {
            throw new Exception("Block does not exist");
        }

        block.setId(Integer.valueOf(id));

        return updateBlockOutputPort.update(block);
    }
}
