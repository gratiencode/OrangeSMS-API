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
public class OutboundSMSTextMessage {
    private String message;

    public OutboundSMSTextMessage() {
    }

    public OutboundSMSTextMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
    
}
