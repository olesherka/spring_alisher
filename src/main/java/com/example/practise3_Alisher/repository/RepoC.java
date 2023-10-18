package com.example.practise3_Alisher.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class RepoC implements com.example.practise3_Alisher.repository.Repository {
    public void method(){
        System.out.println("class {RepoC} method called");
    }
}