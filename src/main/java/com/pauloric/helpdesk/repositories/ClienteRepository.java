package com.pauloric.helpdesk.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.pauloric.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
