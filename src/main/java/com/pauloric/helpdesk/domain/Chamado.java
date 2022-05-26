package com.pauloric.helpdesk.domain;

import java.time.LocalDate;

import com.pauloric.helpdesk.domain.enums.Prioridade;
import com.pauloric.helpdesk.domain.enums.Status;

public class Chamado {
	
	private Integer id;
	private LocalDate dataAbertura = LocalDate.now();
	private LocalDate dataFechamento;
	private Prioridade prioridade;
	private Status status;
	private String titulo;
	private String observacoes;
	
	

}
