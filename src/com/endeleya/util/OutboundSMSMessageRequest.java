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
    private OutboundSMSTextMessage outboundSMSTextMessage;
    private String senderAddress;//:"tel:+{{dev_phone_number}}", \
    private String senderName;
    

    public OutboundSMSMessageRequest() {
    }

    /**
     *klwN2t2ya0Zg2gsmNm2l9w1UqGsG
     *  "address": "string",
    "outboundSMSTextMessage": {
      "message": "string"
    },
    "senderAddress": "string",
    "senderName": "string"
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
