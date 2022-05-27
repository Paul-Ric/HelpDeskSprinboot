package com.pauloric.helpdesk.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pauloric.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
