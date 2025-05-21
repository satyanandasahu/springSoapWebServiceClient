package com.example.satya.ws.client;

import org.springframework.context.annotation.Bean;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;

@Component
public class Config {
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
		jaxb2Marshaller.setContextPath("com.example.satya.vo");
		return jaxb2Marshaller;
	}
	
	@Bean
	public WebServiceGatewayClient webServiceGatewayClient(Jaxb2Marshaller marshaller) {
		WebServiceGatewayClient webServiceGatewayClient = new WebServiceGatewayClient();
		webServiceGatewayClient.setDefaultUri("http://vo.satya.example.com");
		webServiceGatewayClient.setMarshaller(marshaller);
		webServiceGatewayClient.setUnmarshaller(marshaller);
		return webServiceGatewayClient;
	}

}
