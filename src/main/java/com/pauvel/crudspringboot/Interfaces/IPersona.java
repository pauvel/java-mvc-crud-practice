package com.pauvel.crudspringboot.Interfaces;

import com.pauvel.crudspringboot.Model.Persona;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer> {
    
}