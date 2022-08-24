package br.com.api.prova.model.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.prova.model.dto.ComandaDTO;
import br.com.api.prova.model.dto.NoProductsComandaDTO;
import br.com.api.prova.model.dto.ProdutoDTO;
import br.com.api.prova.model.entity.Comanda;
import br.com.api.prova.model.entity.Produto;
import br.com.api.prova.model.repository.ComandaRepository;

@Service
public class ComandaService 
{
    @Autowired
    ComandaRepository usuarioRepository;

    public List<NoProductsComandaDTO> getAll() 
    {
    	List<NoProductsComandaDTO> comandas;
    	comandas = usuarioRepository.findAll().stream().map(
            comanda -> {
                return new NoProductsComandaDTO(comanda.getIdUsuario(), 
                					  comanda.getNomeUsuario(), 
                					  comanda.getTelefoneUsuario());
            }).collect(Collectors.toList());
    	return comandas;
	}
	
	public Optional<ComandaDTO> getById(Integer id) 
	{
		Optional<Comanda> comanda = usuarioRepository.findById(id);
		if (comanda.isPresent()) 
		{
			return Optional.ofNullable(comanda.get().getDTO());
		}
		else 
		{
			return Optional.empty();
		}
	}
	
	public ComandaDTO save(ComandaDTO dto) {
		
		Comanda comanda = usuarioRepository.save(dto.convertToEntity());
		return comanda.getDTO();

	}

    public Optional<ComandaDTO> update(ComandaDTO usuario, Integer id)
	{
    	Optional<Comanda> optComanda = this.usuarioRepository.findById(id);
    	if (optComanda.isPresent())
    	{
        	Comanda comanda = this.updateComandaIfExists(usuario, id);
    		return Optional.of(comanda.getDTO()); 
    	}
    	else
    	{
    		return Optional.empty();
    	}

	}  

	private Comanda updateComandaIfExists(ComandaDTO comanda, Integer id) {
		Comanda comandaEntity = this.getById(id).get().convertToEntity();
		if (comanda.getNomeUsuario() != null)
		{
			comandaEntity.setNomeUsuario(comanda.getNomeUsuario());
		}
		if (comanda.getTelefoneUsuario() != null)
		{
			comandaEntity.setTelefoneUsuario(comanda.getTelefoneUsuario());
		}
		if (comanda.getProdutos() != null)
		{
			comandaEntity.setProdutos(this.updateListProdutos(comanda, comandaEntity));
		}
		usuarioRepository.save(comandaEntity);
		return comandaEntity;
	}
	
	private List<Produto> updateListProdutos(ComandaDTO comanda, Comanda comandaEntity) 
	{
		List<Produto> produtosEntity = new ArrayList<Produto>();
		List<ProdutoDTO> produtosDTO = comandaEntity.getDTO().updateProdutos(comanda.getProdutos());
		if (comanda.getProdutos().size() > produtosDTO.size())
		{
			for (ProdutoDTO pdto : comanda.getProdutos())
			{
				if (!produtosDTO.contains(pdto))
				{
					produtosEntity.add(pdto.convertToEntity());
				}
			}
		} 
		else if (produtosDTO.isEmpty())
		{
			for (ProdutoDTO pdto : comanda.getProdutos())
			{
				produtosEntity.add(pdto.convertToEntity());
			}
		}
		else
		{
			for (ProdutoDTO pdto : produtosDTO) 
			{
				produtosEntity.add(pdto.convertToEntity());
			}	
		}

		return produtosEntity;
	}
    
	public Optional<String> delete(Integer idUsuario)
	{
		Optional<Comanda> usuario = usuarioRepository.findById(idUsuario);
		if (usuario.isPresent())
		{
			usuarioRepository.delete(usuario.get());
			
			Optional<String> message = Optional.of(new JSONObject()
													.put("success", new JSONObject().put("text", "comanda removida"))
													.toString());
			return message;
		}
		else
		{
			return Optional.empty();
		}
	}
 
}
