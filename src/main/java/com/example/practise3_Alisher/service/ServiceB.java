package com.example.practise3_Alisher.service;

import com.example.practise3_Alisher.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ServiceB {
    private Repository repositoryB;
    @Value("class {ServiceB} method called")
    private String serviceBMsg;
    @Autowired
    public ServiceB(@Qualifier("repoB") Repository repositoryB) {
        this.repositoryB = repositoryB;
    }

    public void methodServiceB(){
        log.info(serviceBMsg);
        repositoryB.method();
    }
}