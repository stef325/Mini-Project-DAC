package br.edu.ifpb.dac.stef.projetojpa2.model.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Cat implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    private String name;
    private Integer age;
    private String pelagem;

    @ManyToOne(fetch = FetchType.EAGER)
    private Person dono;
    
    @Override
    public String toString() {
        String owner = "";
        if(dono == null){
            owner = "sem dono";
        }
        else{
            owner= getDono().getName();
        }
        return "ID: " +getId() + " - Nome: " + getName() + ", Idade: " + getAge()+", Pelagem: "+getPelagem()+", Adotado? : " + owner;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cat)) {
            return false;
        }
        Cat cat = (Cat) o;
        return Objects.equals(id, cat.id) && Objects.equals(name, cat.name) && age == cat.age && Objects.equals(pelagem, cat.pelagem) && Objects.equals(dono, cat.dono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, pelagem, dono);
    }

}
