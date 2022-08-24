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

import br.com.api.prova.model.dto.ComandaDTO;
import br.com.api.prova.model.dto.NoProductsComandaDTO;
import br.com.api.prova.model.service.ComandaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

// responsável por controlar as requisições
@CrossOrigin("*")
@RestController
@RequestMapping("/RestAPIFurb/comandas")
@Api(value = "Controller de comanda")
public class ComandaController
{
	@Autowired
	ComandaService service;
	
	@ApiOperation(value = "Retorna uma lista de comandas disponíveis.")
	@GetMapping
	public ResponseEntity<List<NoProductsComandaDTO>> getAll()
	{
		List<NoProductsComandaDTO> lista = service.getAll();
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
	public ResponseEntity<ComandaDTO> getById(@ApiParam(value = "Id da comanda a ser buscada",example = "1",required=true)@PathVariable("id") Integer id)
	{
		Optional<ComandaDTO> usuarioDTO = service.getById(id);
		if (usuarioDTO.isPresent()) 
		{
			return new ResponseEntity<>(usuarioDTO.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@ApiOperation(value = "Adiciona uma comanda. Para adicionar com produtos, é necessário primeiro criar produtos.")
	@PostMapping
	public ResponseEntity<ComandaDTO> addComanda(@ApiParam(value = "Comanda a ser inserida",required=true) @RequestBody ComandaDTO comanda)
	{
		try 
		{
			service.save(comanda);
			return new ResponseEntity<>(comanda, HttpStatus.CREATED);
		} 
		catch (Exception e)
		{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "Edita uma comanda, é possível passar somente os parâmetros desejados para edição.")
	@PutMapping("/{id}")
	public ResponseEntity<ComandaDTO> updateComanda(@ApiParam(value = "Id da comanda a ser editada",example = "1",required=true)@PathVariable Integer id, 
			@ApiParam(value = "O que se quer editar na comanda")@RequestBody ComandaDTO comanda)
	{
		Optional<ComandaDTO> optUsuario = service.update(comanda, id);
		if (optUsuario.isPresent())
		{
			return new ResponseEntity<>(optUsuario.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@ApiOperation(value = "Deleta uma comanda.")
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteComanda(@ApiParam(value = "Id da comanda a ser deletada",example = "1", required=true)@PathVariable Integer id)
	{
		Optional<String> optString = service.delete(id);
		if (optString.isPresent())
		{
			return new ResponseEntity<>(optString.get(), HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
