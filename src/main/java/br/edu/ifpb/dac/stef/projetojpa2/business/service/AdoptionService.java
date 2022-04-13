package br.edu.ifpb.dac.stef.projetojpa2.business.service;

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
    
    public boolean adopt(String catName, Long adopterCpf){
        Person adopter = personService.getOne(adopterCpf);
        if (validationService.validateAge(adopter.getAge())==true) {
           catDAO.setCatDonoById(adopter, catName);
           return true;
        }
        else{
            return false;
        }
        

    }
}
