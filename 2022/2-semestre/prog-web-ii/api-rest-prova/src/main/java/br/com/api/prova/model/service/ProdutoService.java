package br.com.api.prova.model.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.prova.model.dto.ProdutoDTO;
import br.com.api.prova.model.entity.Produto;
import br.com.api.prova.model.repository.ProdutoRepository;

@Service
public class ProdutoService 
{
    @Autowired
    ProdutoRepository produtoRepository;
    
    public List<ProdutoDTO> getAll() 
    {
    	List<ProdutoDTO> produtos;
    	produtos = produtoRepository.findAll().stream().map(
            produto -> {
                return new ProdutoDTO(produto.getId(), produto.getNome(), produto.getPreco());
            }).collect(Collectors.toList());
    	return produtos;
	}
    
	public Optional<ProdutoDTO> getById(Integer id) 
	{
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) 
		{
			return Optional.ofNullable(produto.get().getDTO());
		}
		else 
		{
			return Optional.empty();
		}
	}

	public ProdutoDTO save(ProdutoDTO dto) {
		Produto produto = produtoRepository.save(dto.convertToEntity());
		return produto.getDTO();
	}

    public Optional<ProdutoDTO> update(ProdutoDTO produto, Integer id)
	{
    	Produto produtoEntity = this.getById(id).get().convertToEntity();
		if (produto.getNome() != null)
		{
			produtoEntity.setNome(produto.getNome());
		}
		if (produto.getPreco() != null)
		{
			produtoEntity.setPreco(produto.getPreco());
		}
		produtoRepository.save(produtoEntity);
		return Optional.of(produtoEntity.getDTO());
	}  
    
	public Boolean delete(Integer id)
	{
		Optional<ProdutoDTO> opt = getById(id);
		if (opt.isPresent())
		{
			produtoRepository.delete(opt.get().convertToEntity());
			return true;
		} 
		else
		{
			return false;
		}
	}
}
