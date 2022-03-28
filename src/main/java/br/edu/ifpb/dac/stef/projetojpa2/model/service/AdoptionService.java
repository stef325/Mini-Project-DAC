package br.edu.ifpb.dac.stef.projetojpa2.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.stef.projetojpa2.model.dao.CatDAO;
import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;

@Service
public class AdoptionService {
    
    @Autowired
    private ValidationService validationService;

    @Autowired
    private PersonService personService;

    @Autowired
    private CatDAO catDAO;
    
    public void adopt(String catName, int adopterCpf){
        Person adopter = personService.getOne(adopterCpf);
        if (validationService.validateAge(adopter.getAge())==true) {
           catDAO.setCatDonoById(adopter, catName);
        }
        else{
            System.out.println("É nescessário ter mais de 18 anos para adotar um gato. Caso seja menor de idade, nescessário responsável.");
        }
        

    }
}
