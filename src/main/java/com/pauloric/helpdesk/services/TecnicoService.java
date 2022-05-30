package com.pauloric.helpdesk.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloric.helpdesk.domain.Tecnico;
import com.pauloric.helpdesk.repositories.TecnicoRepository;
import com.pauloric.helpdesk.services.exceptions.ObjectnotFoundException;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico>obj= repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto nao encontrado"+id));
	}
}
