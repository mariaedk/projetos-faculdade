package br.com.api.prova.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.prova.model.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>
{}
