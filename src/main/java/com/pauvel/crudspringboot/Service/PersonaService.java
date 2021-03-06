package com.pauvel.crudspringboot.Service;

import java.util.List;
import java.util.Optional;

import com.pauvel.crudspringboot.InterfaceService.IPersonaService;
import com.pauvel.crudspringboot.Interfaces.IPersona;
import com.pauvel.crudspringboot.Model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService{

    @Autowired
    private IPersona data;

    @Override
    public List<Persona> listar() {
        return (List<Persona>)data.findAll();
    }

    @Override
    public Optional<Persona> listarId(int id) {
        return this.data.findById(id);
    }

    @Override
    public int save(Persona p) {
        int response = 0;
        Persona persona = data.save(p);

        if(!persona.equals(null)){
            response = 1;
        }

        return response;
    }

    @Override
    public void delete(int id) {
        this.data.deleteById(id);
    }
    
}