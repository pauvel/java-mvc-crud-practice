package com.pauvel.crudspringboot.Controller;

import java.util.List;
import java.util.Optional;

import com.pauvel.crudspringboot.InterfaceService.IPersonaService;
import com.pauvel.crudspringboot.Model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/new")
    public String agregar(Model model){
        model.addAttribute("persona", new Persona());
        return "form";
    }

    @PostMapping("/save")
    public String save(@Validated Persona p, Model model){
        this.service.save(p);
        return "redirect:/listar";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model){
        Optional<Persona> persona = this.service.listarId(id);
        model.addAttribute("persona", persona);
        return "form";
    }

    @GetMapping("/eliminar/{id}") // CHANGE VERB TO DELETE.
    public String delete(@PathVariable int id){
        this.service.delete(id);
        return "redirect:/listar";
    }

    @GetMapping("/properties")
    public String getProps(){
        // ConfigHelper cnf = new ConfigHelper("ES");
        // Map<String, String> props = cnf.getProperties();

        return "index";
    }
    
}