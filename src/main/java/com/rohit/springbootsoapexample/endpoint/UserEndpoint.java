package com.rohit.springbootsoapexample.endpoint;

import com.rohit.spring_boot_soap_example.GetUserRequest;
import com.rohit.spring_boot_soap_example.GetUserResponse;
import com.rohit.springbootsoapexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

@Endpoint
public class UserEndpoint {
    @Autowired
    private Jaxb2Marshaller marshaller;


    @Autowired
    private UserService userService;


    @PayloadRoot(namespace = "http://rohit.com/spring-boot-soap-example",
            localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) throws JAXBException {
        GetUserResponse response = new GetUserResponse();
        response.setUser(userService.getUsers(request.getName()));
        // Print the response XML to the console
        System.out.println("soap request:");
        JAXBContext jaxbContext = JAXBContext.newInstance(GetUserRequest.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(request, System.out);
        System.out.println("\n \n \n\n\n\n\n\n\n\n\n\n\n\n\n soap response");
        JAXBContext jaxbContext1 = JAXBContext.newInstance(GetUserResponse.class);
        Marshaller marshaller1 = jaxbContext1.createMarshaller();
        marshaller1.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller1.marshal(response, System.out);
        return response;
    }
}
