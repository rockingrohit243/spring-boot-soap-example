package com.rohit.springbootsoapexample.service;

import com.rohit.spring_boot_soap_example.User;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    private static final Map<String, User> users = new HashMap<>();

    @PostConstruct
    public void initialize() {

        User rohit = new User();
        rohit.setName("Rohit");
        rohit.setEmpId(1111);
        rohit.setSalary(12000);

        User Nitish = new User();
        Nitish.setName("Nitish");
        Nitish.setEmpId(1112);
        Nitish.setSalary(32000);
        User Dj = new User();
        Dj.setName("Dj");
        Dj.setEmpId(1113);
        Dj.setSalary(16000);

        users.put(rohit.getName(), rohit);
        users.put(Nitish.getName(), Nitish);
        users.put(Dj.getName(), Dj);
    }


    public User getUsers(String name) {
        return users.get(name);
    }
}
