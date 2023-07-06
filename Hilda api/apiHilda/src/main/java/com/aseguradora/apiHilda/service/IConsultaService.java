package com.aseguradora.apiHilda.service;

import com.aseguradora.apiHilda.model.Consulta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IConsultaService {

    public List<Consulta> verConsultas();
    public void borrarConsultas(Long id);
    public Consulta agregarConsulta(Consulta consulta);

}
