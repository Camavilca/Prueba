/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.albatrosscloud.controller;

import com.albatrosscloud.model.Persona;
import com.albatrosscloud.repository.PersonaRepository;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alba
 */
@RestController
@RequestMapping("/api")
public class PersonaController {
    
    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/lista")
    public List<Persona> listaPersonas() {
        return personaRepository.findAll();
    }
    @GetMapping("/buscar/{id}")
    public Optional<Persona> buscar(@PathVariable long id){
        return personaRepository.findById(id);
    }
    @DeleteMapping("/eliminar/{id}")
    public void eliminarPersona(@PathVariable long id) {
        personaRepository.deleteById(id);
    }
    @PostMapping("/guardar")
    public Persona createPersona(@Valid @RequestBody Persona persona) {
        return personaRepository.save(persona);
    }
}
