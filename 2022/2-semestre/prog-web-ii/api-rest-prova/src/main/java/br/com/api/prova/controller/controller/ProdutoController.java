package br.com.api.prova.controller.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.prova.model.dto.ProdutoDTO;
import br.com.api.prova.model.service.ProdutoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin("*")
@RestController

@RequestMapping("/RestAPIFurb/produto")
// somente quem estiver autenticado vai poder acessar estes endpoints
public class ProdutoController
{
	@Autowired
	ProdutoService service;
	
	@GetMapping

	@ApiOperation(value = "Retorna uma lista de produtos disponíveis.")
	public ResponseEntity<List<ProdutoDTO>> getAll()
	{
		List<ProdutoDTO> lista = service.getAll();
		if (lista.isEmpty()) 
		{
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} 
		else 
		{
			return new ResponseEntity<>(lista, HttpStatus.OK);
		}
	}
	
	@ApiOperation(value = "Ao passar um id como parâmetro na URL, retorna o objeto se encontrado.")
	@GetMapping("/{id}")

	public ResponseEntity<ProdutoDTO> getById(@ApiParam(value = "Id do produto a ser buscado", example = "1",required=true)@PathVariable("id") Integer id)
	{
		Optional<ProdutoDTO> produtoDTO = service.getById(id);
		if (produtoDTO.isPresent()) 
		{
			return new ResponseEntity<>(produtoDTO.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@ApiOperation(value = "Adiciona um produto.")
	@PostMapping

	public ResponseEntity<ProdutoDTO> addProduto(@ApiParam(value = "Produto que vai ser adicionado",required=true)@RequestBody ProdutoDTO produto)
	{
		return new ResponseEntity<>(service.save(produto), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")

	@ApiOperation(value = "Edita um produto, é possível passar somente os parâmetros desejados para edição.")
	public ResponseEntity<ProdutoDTO> updateProduto(@ApiParam(value = "Id do produto a ser editado",example = "1",required=true)@PathVariable Integer id, 
			@ApiParam(value = "O que se deseja editar do produto")@RequestBody ProdutoDTO produto) throws Exception
	{
		Optional<ProdutoDTO> optProduto = service.update(produto, id);
		if (optProduto.isPresent())
		{
			return new ResponseEntity<>(optProduto.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/{id}")

	@ApiOperation(value = "Deleta um produto.")
	public ResponseEntity<Boolean> deleteProduto(@ApiParam(value = "Id do produto a ser deletado",example = "1",required=true)@PathVariable Integer id)
	{
		Boolean isDeleted = service.delete(id);
		if (isDeleted)
		{
			return new ResponseEntity<>(isDeleted, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}

