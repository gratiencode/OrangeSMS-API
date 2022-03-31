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

    @Override
    public int hashCode() {
        int hash = 7;
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
        final OutboundSMSTextMessage other = (OutboundSMSTextMessage) obj;
        if (!Objects.equals(this.message, other.message)) {
            return false;
        }
        return true;
    }
    
    
}
