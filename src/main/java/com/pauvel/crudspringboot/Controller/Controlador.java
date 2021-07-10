package com.pauvel.crudspringboot.Controller;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import com.pauvel.crudspringboot.Helpers.ConfigHelper;
import com.pauvel.crudspringboot.InterfaceService.IPersonaService;
import com.pauvel.crudspringboot.Model.Persona;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class Controlador {
    
    @Autowired
    private IPersonaService service;
    
    @GetMapping("/")    
    public String home(Model model){
        return "index";
    }

    @GetMapping("/listar")
    public String listar(Model model, HttpServletRequest request){


        /**
         * Language feature
         */
        Locale currentLocale = request.getLocale();

        String countryCode = currentLocale.getCountry();
        String countryName = currentLocale.getDisplayCountry();

        String langCode = currentLocale.getLanguage();
        String langName = currentLocale.getDisplayLanguage();

        System.out.println(countryCode +": "+ countryName);
        System.out.println(langCode +": "+ langName);

        List<Persona> personas = service.listar();
        model.addAttribute("personas", personas);
        return "listar";
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
    public String getProps(Model model){
        ConfigHelper cnf = new ConfigHelper("ES");
        Map<String, String> props = cnf.getProperties();
        model.addAttribute("props", props);
        return "properties";
    }

    @GetMapping("/properties/{key}")
    public String getProps(Model model, @PathVariable String key) {
        ConfigHelper cnf = new ConfigHelper("ES");
        String prop = cnf.getPropertyValue(key);
        model.addAttribute("prop", prop);
        model.addAttribute("searchedProp", key);
        return "property";
    }
    
}