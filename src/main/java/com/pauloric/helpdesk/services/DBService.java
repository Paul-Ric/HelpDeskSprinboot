package com.pauloric.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pauloric.helpdesk.domain.Chamado;
import com.pauloric.helpdesk.domain.Cliente;
import com.pauloric.helpdesk.domain.Tecnico;
import com.pauloric.helpdesk.domain.enums.Perfil;
import com.pauloric.helpdesk.domain.enums.Prioridade;
import com.pauloric.helpdesk.domain.enums.Status;
import com.pauloric.helpdesk.repositories.ChamadoRepository;
import com.pauloric.helpdesk.repositories.PessoaRepository;

@Service
public class DBService {

	@Autowired
	private ChamadoRepository chamadoRepository;
	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Tecnico tec0 = new Tecnico(null, "Paulo Ricardo", "021.712.706-16", "paulo@gmail.com", encoder.encode("123"));
		tec0.addPerfil(Perfil.ADMIN);

		Tecnico tec1 = new Tecnico(null, "Jao", "550.482.150-95", "joao@gmail.com", encoder.encode("123"));
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Tiago Sergio", "903.347.070-56", "tiago@gmail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Cinthia RH", "271.068.470-54", "cithia@gmail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Celia Financeiro", "162.720.120-39", "cela@gmail.com", encoder.encode("123"));
		Tecnico tec5 = new Tecnico(null, "Suporte 1", "778.556.170-27", "suporte@mail.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "SUB-SEDE-1", "111.661.890-74", "sede1@gmail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "SUB-SEDE-2", "322.429.140-06", "sede2@gmail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "SUB-SEDE-3", "792.043.830-62", "sede3@gmail.com", encoder.encode("123"));
		Cliente cli4 = new Cliente(null, "SUB-SEDE-4", "177.409.680-30", "sede4@gmail.com", encoder.encode("123"));
		Cliente cli5 = new Cliente(null, "SUB-SEDE-5", "081.399.300-83", "sede5@gmail.com", encoder.encode("123"));
 
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 1", "Teste chamado 1", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 2", "Teste chamado 2", tec1, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 3", "Teste chamado 3", tec2, cli3);
		Chamado c4 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 4", "Teste chamado 4", tec3, cli3);
		Chamado c5 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 5", "Teste chamado 5", tec2, cli1);
		Chamado c6 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 7", "Teste chamado 6", tec1, cli5);

		pessoaRepository.saveAll(Arrays.asList(tec0, tec1, tec2, tec3, tec4, tec5, cli1, cli2, cli3, cli4, cli5));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6));
	}
}
