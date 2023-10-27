package com.hostfully.bookingapi.application.core.domain;

import java.time.LocalDate;
import java.util.List;

public class Booking {

    private Integer id;

    private LocalDate startPeriod;

    private LocalDate endPeriod;

    private String guestFirstName;

    private String guestLastName;

    private Integer guestDocumentId;

    private Integer propertyId;

    public String getGuestFirstName() {
        return guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        return guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public Integer getGuestDocumentId() {
        return guestDocumentId;
    }

    public void setGuestDocumentId(Integer guestDocumentId) {
        this.guestDocumentId = guestDocumentId;
    }

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

    public Integer getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDate getEndPeriod() {
        return endPeriod;
    }

    public void setEndPeriod(LocalDate endPeriod) {
        this.endPeriod = endPeriod;
    }

}
