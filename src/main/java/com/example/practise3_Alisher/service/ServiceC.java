package com.example.practise3_Alisher.service;

import com.example.practise3_Alisher.repository.RepoC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ServiceC {

    private ServiceB serviceB = new ServiceB();
    private RepoC repoC = new RepoC();

    @Value("class {ServiceC} method called")
    private String serviceCMsg;
    public void methodServiceC(){
        System.out.println("class {ServiceC} method called");
        serviceB.methodServiceB();
        repoC.methodRepoC();
    }
}
