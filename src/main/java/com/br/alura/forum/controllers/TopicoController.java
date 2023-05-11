package com.br.alura.forum.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.br.alura.forum.domain.topico.DadosAtualizarTopico;
import com.br.alura.forum.domain.topico.DadosCadastroTopico;
import com.br.alura.forum.domain.topico.DadosListagemTopico;
import com.br.alura.forum.domain.topico.TopicoRepository;
import com.br.alura.forum.modelo.Topico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroTopico dados) {
		repository.save(new Topico(dados));
	}
	
	@GetMapping
	public Page<DadosListagemTopico> listar(@PageableDefault(size=10, sort = {"dataCriacao"}) Pageable paginacao, @RequestParam(name = "search") String search) {
		
		if(search != "") {
			return repository.findByTitle(search, paginacao).map(DadosListagemTopico::new);
		}
		
		return repository.findAll(paginacao).map(DadosListagemTopico::new);
	}
	
	@GetMapping("{id}")
	public Optional<DadosListagemTopico> detalhe(@PathVariable  Long id) {
		System.out.println("Id: "+id);
		
		return repository.findById(id).map(DadosListagemTopico::new);
	}
	
	@PutMapping("{id}")
	@Transactional
	public void atualizar(@RequestBody @Valid DadosCadastroTopico dados, @PathVariable Long id) {
		var topico = repository.getReferenceById(id);
		
		topico.atualizarInfo(dados);
	}
	
	@DeleteMapping("{id}")
	@Transactional
	public void deletar(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	
}