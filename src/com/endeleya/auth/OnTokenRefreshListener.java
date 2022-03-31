/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeleya.auth;

import com.endeleya.util.Token;

/**
 *
 * @author eroot
 */
public interface OnTokenRefreshListener {
    public void onTokenRefresh(Token token);
}
