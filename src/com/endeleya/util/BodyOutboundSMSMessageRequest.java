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
public class BodyOutboundSMSMessageRequest {
    private OutboundSMSMessageRequest outboundSMSMessageRequest; 

    public BodyOutboundSMSMessageRequest() {
    }

    public OutboundSMSMessageRequest getOutboundSMSMessageRequest() {
        return outboundSMSMessageRequest;
    }

    public void setOutboundSMSMessageRequest(OutboundSMSMessageRequest outboundSMSMessageRequest) {
        this.outboundSMSMessageRequest = outboundSMSMessageRequest;
    }
   
}
