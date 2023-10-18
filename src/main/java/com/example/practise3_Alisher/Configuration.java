package com.example.practise3_Alisher;

import com.example.practise3_Alisher.repository.RepoA;
import com.example.practise3_Alisher.repository.RepoB;
import com.example.practise3_Alisher.repository.RepoC;
import com.example.practise3_Alisher.service.ServiceA;
import com.example.practise3_Alisher.service.ServiceB;
import com.example.practise3_Alisher.service.ServiceC;
import com.example.practise3_Alisher.service.ServiceD;
import org.springframework.context.annotation.Bean;
@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean("serviceAFromConfiguration")
    public ServiceA getServiceA(){
        ServiceA serviceA = new ServiceA(new RepoA());
        return serviceA;
    }

    @Bean("serviceBFromConfiguration")
    public ServiceB getServiceB(){
        ServiceB serviceB = new ServiceB( new RepoB());
        return serviceB;
    }

    @Bean("serviceCFromConfiguration")
    public ServiceC getServiceC(){
        ServiceC serviceC = new ServiceC( new RepoC());
        return serviceC;
    }

    @Bean("serviceDFromConfiguration")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(new ServiceC(new RepoC()));
        return serviceD;
    }

}
