package com.example.practise3_Alisher.service;

import com.example.practise3_Alisher.repository.RepoA;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Service
public class ServiceA {

    @Value("class {ServiceA} method called")
    private String serviceAMsg;
    private RepoA repoA = new RepoA();
    public void methodServiceA(){
        System.out.println(serviceAMsg);
        repoA.methodRepoA();
    }
}