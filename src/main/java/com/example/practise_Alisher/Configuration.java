package com.example.practise_Alisher;

import com.example.practise_Alisher.repository.RepoA;
import com.example.practise_Alisher.repository.RepoB;
import com.example.practise_Alisher.repository.RepoC;
import com.example.practise_Alisher.service.ServiceA;
import com.example.practise_Alisher.service.ServiceB;
import com.example.practise_Alisher.service.ServiceC;
import com.example.practise_Alisher.service.ServiceD;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

@org.springframework.context.annotation.Configuration
@PropertySource(value = "classpath:application,properties")
public class Configuration {
    @Value("${value.from.application:default}:")
    private String value;
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

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public ServiceD getServiceD(){
        ServiceD serviceD = new ServiceD(new ServiceC(new RepoC()));
        return serviceD;
    }

}
