package com.pauloric.helpdesk.services;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pauloric.helpdesk.domain.Chamado;
import com.pauloric.helpdesk.domain.Cliente;
import com.pauloric.helpdesk.domain.Tecnico;
import com.pauloric.helpdesk.domain.enums.Perfil;
import com.pauloric.helpdesk.domain.enums.Prioridade;
import com.pauloric.helpdesk.domain.enums.Status;
import com.pauloric.helpdesk.repositories.ChamadoRepository;
import com.pauloric.helpdesk.repositories.ClienteRepository;
import com.pauloric.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instanciaDB() {
		Tecnico tec1= new Tecnico(null, "Paulo Ricardo","02171270616", "paulo@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1= new Cliente(null, "Linus Torvalds","00000000000", "tovalds@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA,Status.ANDAMENTO , "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}
}
