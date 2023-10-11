package com.example.practise3_Alisher.repository;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Repository
public class RepoA {
    public RepoA() {
    }

    public void methodRepoA(){
        System.out.println("class {RepoA} method called");
    }
}