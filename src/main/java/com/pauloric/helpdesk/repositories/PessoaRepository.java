package com.pauloric.helpdesk.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pauloric.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
