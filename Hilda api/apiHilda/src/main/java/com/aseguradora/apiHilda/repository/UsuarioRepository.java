
package com.aseguradora.apiHilda.repository;

import com.aseguradora.apiHilda.model.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Integer >{

    Optional<Usuarios> findByMail(String mail);


}
