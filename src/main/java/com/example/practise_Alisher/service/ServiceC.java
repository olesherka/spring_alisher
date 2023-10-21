package com.example.practise_Alisher.service;

import com.example.practise_Alisher.repository.Repository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
@Service
@Slf4j
public class ServiceC {
    private Repository repositoryC;
    @Value("class {ServiceC} method called")
    private String serviceCMsg;
    @Autowired
    public ServiceC(@Qualifier("repoC") Repository repositoryC) {
        this.repositoryC = repositoryC;
    }

    public void methodServiceC(){
        log.info(serviceCMsg);
        repositoryC.method();
    }
}
