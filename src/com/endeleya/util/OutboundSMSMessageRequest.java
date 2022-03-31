/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeleya.util;

import java.util.Objects;

/**
 *
 * @author eroot
 */
public class OutboundSMSMessageRequest {

    private String address;// "tel:+{{recipient_phone_number}}", \
    private String senderAddress;//:"tel:+{{dev_phone_number}}", \
    private String senderName;
    private OutboundSMSTextMessage outboundSMSTextMessage;

    public OutboundSMSMessageRequest() {
    }

    /**
     *
     * @param address
     * @param senderAddress
     */
    public OutboundSMSMessageRequest(String address, String senderAddress) {
        this.address = address;
        this.senderAddress = senderAddress;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = "tel:+" + senderAddress;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = "tel:+" + address;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.address);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OutboundSMSMessageRequest other = (OutboundSMSMessageRequest) obj;
        if (!Objects.equals(this.address, other.address)) {
            return false;
        }
        return true;
    }

    public OutboundSMSTextMessage getOutboundSMSTextMessage() {
        return outboundSMSTextMessage;
    }

    public void setOutboundSMSTextMessage(OutboundSMSTextMessage outboundSMSTextMessage) {
        this.outboundSMSTextMessage = outboundSMSTextMessage;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

}
