package com.pauvel.crudspringboot.Controller;

import java.util.List;

import com.pauvel.crudspringboot.InterfaceService.IPersonaService;
import com.pauvel.crudspringboot.Model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {

    @Autowired
    private IPersonaService service;

    @GetMapping("/listar")
    public String listar(Model model){
        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);

        return "index";
    }
    
}