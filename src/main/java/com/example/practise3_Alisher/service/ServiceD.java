package com.example.practise3_Alisher.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ServiceD {
    private ServiceC serviceC = new ServiceC();

    @Value("class {ServiceD} method called")
    private String serviceDMsg;
    public void methodServiceD(){
        System.out.println("class {ServiceD} method called");
        serviceC.methodServiceC();
    }

}