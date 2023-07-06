
package com.aseguradora.apiHilda.service;

import com.aseguradora.apiHilda.model.Usuarios;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IUsuarioService {
    public List<Usuarios>verUsuarios();
    public void nuevoUsuario(Usuarios usuarios);
    public void borrarUsuario(Long id);
}
