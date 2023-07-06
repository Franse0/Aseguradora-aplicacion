package com.aseguradora.apiHilda.security;

import com.aseguradora.apiHilda.model.Usuarios;
import com.aseguradora.apiHilda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServisImpl implements UserDetailsService {

        @Autowired
        UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Usuarios usuarios = usuarioRepository.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario con email " + mail +"no existe"));
        return new UserDetailsImpl(usuarios);
    }
}
