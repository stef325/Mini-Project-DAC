package br.edu.ifpb.dac.stef.projetojpa2.model.service;

import org.springframework.stereotype.Service;

@Service
public class ValidationService {
    
    public boolean validateAge(int age){
        return age >=18? true : false;
    }

}
