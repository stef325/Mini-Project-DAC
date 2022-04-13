package br.edu.ifpb.dac.stef.projetojpa2.presentation.dto;

import br.edu.ifpb.dac.stef.projetojpa2.model.entity.Person;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class CatDTO {

    private Integer id;
    private String name;
    private Integer age;
    private String pelagem;

    private String dono;
    
}
