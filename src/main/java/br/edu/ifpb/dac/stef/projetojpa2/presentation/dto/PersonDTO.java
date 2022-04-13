package br.edu.ifpb.dac.stef.projetojpa2.presentation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonDTO {
     
    private Integer id;

    private Long cpf;

    private String name;
    
    private Integer age;

}
