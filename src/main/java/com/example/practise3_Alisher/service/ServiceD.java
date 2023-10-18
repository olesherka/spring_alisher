package com.example.practise3_Alisher.service;


import com.example.practise3_Alisher.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ServiceD {
    private ServiceC serviceC;

    @Value("class {ServiceC} method called")
    private String serviceDMsg;
    @Autowired
    public ServiceD(ServiceC serviceC) {
        this.serviceC = serviceC;
    }

    public void methodServiceD(){
        log.info(serviceDMsg);
        serviceC.methodServiceC();
    }
}