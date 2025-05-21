package com.example.satya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.example.satya.vo.Address;
import com.example.satya.vo.CreatePersonRequest;
import com.example.satya.vo.CreatePersonResponse;
import com.example.satya.vo.GetPersonRequest;
import com.example.satya.vo.GetPersonResponse;
import com.example.satya.vo.Person;
import com.example.satya.ws.client.WebServiceGatewayClient;

@ComponentScan(basePackages = { "com.example" })
public class Main {

	@Autowired
	WebServiceGatewayClient webServiceGatewayClient;

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.register(Main.class);
		annotationConfigApplicationContext.refresh();

		Main main = annotationConfigApplicationContext.getBean(Main.class);

	//	String personId = "1745567535382";
		
		
		
		/* Creating Person Object */
		Person person = new Person();
		Address address = new Address();
		person.setFirstName("SoapClientFN");
		person.setMiddleName("SoapClientMN");
		person.setLastName("SoapClientLN");
		person.setAge(44);
		person.setGender("Male");
		
		person.getAddress().add(address);
		
		address.setAddressLine1("SoapClient addressline 1");
		address.setAddressLine2("SoapClient addressline 2");
		address.setAddressType("Permanent");
		address.setCity("Soap city");
		address.setCountry("soap country");
		address.setDistrictCounty("Soap county");
		address.setPinZipcode("4474944");
		address.setState("Soap state");
		String personId = main.createPerson(person);
		System.out.println("Response: ");
		System.out.println("Person Created with Id: " + personId );
		
		person = main.getPerson(personId);
		System.out.println("Response:");
		System.out.println("Name: " + person.getFirstName() + " " + person.getMiddleName() + " " + person.getLastName()) ;
		System.out.print("\nAddress: " + person.getAddress().get(0).getAddressLine1());
		System.out.print(" " + person.getAddress().get(0).getAddressLine2());
		/*
		 * System.out.print("\n Address: " +
		 * person.getAddress().get(1).getAddressLine1()); System.out.print(" " +
		 * person.getAddress().get(1).getAddressLine2()); System.out.print("\nAddress: "
		 * + person.getAddress().get(2).getAddressLine1()); System.out.print(" " +
		 * person.getAddress().get(2).getAddressLine2());
		 */
		
		
		//phone number: +91 9986488396
		

		annotationConfigApplicationContext.close();

	}

	public Person getPerson(String personId) {
		GetPersonRequest getPersonRequest = new GetPersonRequest();
		getPersonRequest.setPersonId(personId);
		GetPersonResponse getPersonResponse = (GetPersonResponse)webServiceGatewayClient.callWebService(
				"http://localhost:8081/springbootsoap-0.0.1-SNAPSHOT/services/personServiceWsdl.wsdl", getPersonRequest);
		return getPersonResponse.getPerson();
	}

	public String createPerson(Person person) {
		CreatePersonRequest createPersonRequest = new CreatePersonRequest();
		createPersonRequest.setPerson(person);
		CreatePersonResponse createPersonResponse = (CreatePersonResponse)webServiceGatewayClient.callWebService(
				"http://localhost:8081/springbootsoap-0.0.1-SNAPSHOT/services/personServiceWsdl.wsdl", createPersonRequest);
		return createPersonResponse.getPersonId();
	}

}
