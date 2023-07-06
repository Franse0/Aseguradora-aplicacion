
package com.aseguradora.apiHilda.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "usuarios")
public class Usuarios {
        
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    @Basic
    private String username;
    private String password;
    private String mail;

    public Usuarios() {
    }


    public Usuarios(Long id, String username, String password, String mail) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.mail = mail;
    }
}
