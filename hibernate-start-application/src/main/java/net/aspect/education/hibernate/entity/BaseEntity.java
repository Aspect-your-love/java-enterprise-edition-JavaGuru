package net.aspect.education.hibernate.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

import java.io.Serializable;

/*Супертип для Entity*/
@Getter
@MappedSuperclass
public class BaseEntity <T extends Serializable>{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private T id;
}
