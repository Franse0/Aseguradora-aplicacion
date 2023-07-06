package com.aseguradora.apiHilda.service;

import com.aseguradora.apiHilda.model.Consulta;
import com.aseguradora.apiHilda.repository.ConsultaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaService implements  IConsultaService{
    @Autowired
    public ConsultaRepository consultaRepository;
    @Override
    public List<Consulta> verConsultas() {
        return consultaRepository.findAll();
    }

    @Override
    public void borrarConsultas(Long id) {
        consultaRepository.deleteById(id);
    }

    @Override
    public Consulta agregarConsulta(Consulta consulta) {
        return consultaRepository.save(consulta);
    }
}
