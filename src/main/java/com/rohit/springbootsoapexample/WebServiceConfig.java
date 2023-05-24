package com.rohit.springbootsoapexample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class WebServiceConfig {

    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.rohit.springbootsoapexample.endpoint.UserEndpoint"); // Replace with the package containing your JAXB classes
        return marshaller;
    }
}
