package com.example.satya.ws.client;

import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

@Component
public class WebServiceGatewayClient extends WebServiceGatewaySupport {
	
	
	public Object callWebService(String uri, Object object ) {
		return getWebServiceTemplate().marshalSendAndReceive(uri, object);
		
	}

}
