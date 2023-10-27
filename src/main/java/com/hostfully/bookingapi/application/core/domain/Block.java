package com.hostfully.bookingapi.application.core.domain;

import java.time.LocalDate;

public class Block {

    public Block(Integer id, LocalDate startPeriod, LocalDate endPeriod, Integer propertyId) {
        this.id = id;
        this.startPeriod = startPeriod;
        this.endPeriod = endPeriod;
        this.propertyId = propertyId;
    }
    private Integer id;

    private LocalDate startPeriod;

    private LocalDate endPeriod;

    private Integer propertyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStartPeriod() {
        return startPeriod;
    }

    public void setStartPeriod(LocalDate startPeriod) {
        this.startPeriod = startPeriod;
    }

    public LocalDate getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }
}
