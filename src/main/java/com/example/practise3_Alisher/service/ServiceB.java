package com.example.practise3_Alisher.service;

import com.example.practise3_Alisher.repository.RepoB;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ServiceB {
    private ServiceA serviceA = new ServiceA();
    private RepoB repoB = new RepoB();
    @Value("class {ServiceB} method called")
    private String serviceBMsg;
    public String methodServiceB(){
        serviceA.methodServiceA();
        repoB.methodRepoB();
        return("");
    }
}