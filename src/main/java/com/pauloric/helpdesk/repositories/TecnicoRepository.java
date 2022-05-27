package com.pauloric.helpdesk.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pauloric.helpdesk.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {

}
