package br.com.api.prova.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.prova.model.entity.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Integer>
{

}
