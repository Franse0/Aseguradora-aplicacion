
package com.aseguradora.apiHilda.service;

import com.aseguradora.apiHilda.model.Usuarios;
import com.aseguradora.apiHilda.repository.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {
    
    @Autowired
    public UsuarioRepository consultaRepo;

    @Override
    public List<Usuarios> verUsuarios() {
        return consultaRepo.findAll();
    }

    @Override
    public void nuevoUsuario(Usuarios usuarios) {
         consultaRepo.save(usuarios);
    }

    @Override
    public void borrarUsuario(Long id) {

    }


}
