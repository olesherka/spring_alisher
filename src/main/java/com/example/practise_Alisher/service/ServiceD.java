package com.example.practise_Alisher.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    private void init(){
        System.out.println("method called before init");
        Assert.notNull(serviceC, "Service C not null");
    }
    private void destroy(){
        System.out.println("method called after all");
        serviceC = null;
    }

    @PreDestroy
    public void preDestroy() throws IOException{
        log.info("preDestroy method called");
        if(serviceC ==null){
            Files.deleteIfExists((Path) serviceC);
        }
    }

}