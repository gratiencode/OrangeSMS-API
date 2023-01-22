/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.endeleye.core;

import com.endeleya.util.BodyOutboundSMSMessageRequest;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 *
 * @author eroot
 */
public interface OrangeSMS {
  @POST("smsmessaging/v1/outbound/tel%3A%2B{senderAddress}/requests")
  Call<BodyOutboundSMSMessageRequest> sendSms(@Path("senderAddress")String dev_phone,@Body BodyOutboundSMSMessageRequest sms);
}
