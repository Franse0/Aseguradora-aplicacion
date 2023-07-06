package com.aseguradora.apiHilda.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name ="consultas")
@Data
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String consulta;

    public Consulta(Long id, String nombre, String apellido, String mail, String telefono, String consulta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.consulta = consulta;
    }

    public Consulta() {
    }
}
