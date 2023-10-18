package com.example.practise3_Alisher.service;

import com.example.practise3_Alisher.repository.RepoA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ServiceA {
    @Value("class {ServiceA} method called")
    private String serviceAMsg;

    @Autowired
    public void methodServiceA(RepoA repoA){
        log.info(serviceAMsg);
        repoA.methodRepoA();
    }
}