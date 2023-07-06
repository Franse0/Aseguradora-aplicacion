package com.aseguradora.apiHilda.controller;

import com.aseguradora.apiHilda.model.Consulta;
import com.aseguradora.apiHilda.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins="**")
@RequestMapping("api/consulta")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @GetMapping
    @ResponseBody
    public List<Consulta> verConsultas(){
        return consultaService.verConsultas();
    }

    @PostMapping("/nueva")
    public Consulta hacerConsulta(@RequestBody Consulta consulta){
        System.out.println("consulta realizada");
        return consultaService.agregarConsulta(consulta);
    }

    @DeleteMapping("/borrar/{id}")
    public void borrarConsulta(@PathVariable Long id){
        System.out.println("Consulta eliminada");
        consultaService.borrarConsultas(id);
    }

}
