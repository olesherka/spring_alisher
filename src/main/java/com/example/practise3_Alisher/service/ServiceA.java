package com.example.practise3_Alisher.service;

import com.example.practise3_Alisher.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ServiceA {
    private Repository repositoryA;
    @Value("class {ServiceA} method called")
    private String serviceAMsg;
    @Autowired
    public ServiceA(@Qualifier("repoA") Repository repositoryA) {
        this.repositoryA = repositoryA;
    }



    public void methodServiceA(){
        log.info(serviceAMsg);
        repositoryA.method();
    }
}