package com.pauloric.helpdesk.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pauloric.helpdesk.domain.Cliente;
import com.pauloric.helpdesk.domain.Pessoa;
import com.pauloric.helpdesk.domain.dtos.ClienteDTO;
import com.pauloric.helpdesk.repositories.ClienteRepository;
import com.pauloric.helpdesk.repositories.PessoaRepository;
import com.pauloric.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.pauloric.helpdesk.services.exceptions.ObjectnotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Cliente findById(Integer id) {
		Optional<Cliente>obj= repository.findById(id);
		return obj.orElseThrow(()-> new ObjectnotFoundException("Objeto nao encontrado"+id));
	}

	public List<Cliente> findAll() {
		
		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfeEmail(objDTO);
		Cliente newObj= new Cliente(objDTO);
		return repository.save(newObj);
	}
	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj= findById(id);
		validaPorCpfeEmail(objDTO);
		oldObj= new Cliente(objDTO);
		return repository.save(oldObj);
	}
public void delete(Integer id) {
		Cliente obj = findById(id);
		if(obj.getChamados().size()>0) {
			throw new DataIntegrityViolationException("Tecnivo possui ordens de serviço e não pode ser deletado!");
		}else {
			repository.deleteById(id);
		}
		
	}
	private void validaPorCpfeEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj= pessoaRepository.findByCpf(objDTO.getCpf());
		if(obj.isPresent() && obj.get().getId()!= objDTO.getId()){
			throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if(obj.isPresent() && obj.get().getId()!= objDTO.getId()){
			throw new DataIntegrityViolationException("Email já cadastrado no sistema!");
		}
	}

	

	
}