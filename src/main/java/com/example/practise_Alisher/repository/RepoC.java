package com.example.practise_Alisher.repository;

import org.springframework.stereotype.Repository;
@Repository
public class RepoC implements com.example.practise_Alisher.repository.Repository {
    public void method(){
        System.out.println("class {RepoC} method called");
    }
}