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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int save(Persona p) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        
    }
    
}