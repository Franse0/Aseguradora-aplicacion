
package com.aseguradora.apiHilda.controller;

import com.aseguradora.apiHilda.model.Usuarios;
import com.aseguradora.apiHilda.service.IUsuarioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@CrossOrigin(origins="**")
public class UsuarioController {
    
    @Autowired
    private IUsuarioService consultaServ;
    
    
    @GetMapping("/ver/usuarios")
    @ResponseBody
    public List<Usuarios> verConsultas(){
        return consultaServ.verUsuarios();
    }
    
    @PostMapping("nueva/usuario")
    public void crearUsuario(@RequestBody Usuarios usuarios){
        consultaServ.nuevoUsuario(usuarios);
        System.out.println("usuario cargado");
    }
    
    @DeleteMapping("/delete/consulta/id")
    public void borrarConsulta(@PathVariable Long id){
        consultaServ.borrarUsuario(id);
    }
}
