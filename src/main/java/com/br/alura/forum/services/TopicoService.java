package com.br.alura.forum.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.alura.forum.domain.topico.DadosCadastroTopico;
import com.br.alura.forum.domain.topico.DadosDetalheTopico;
import com.br.alura.forum.domain.topico.DadosListagemTopico;
import com.br.alura.forum.domain.topico.TopicoRepository;
import com.br.alura.forum.modelo.Topico;

@Service
public class TopicoService {
	
	@Autowired
	private TopicoRepository repository;
	
	public ResponseEntity salvar(Topico topico, UriComponentsBuilder uriBuilder) {
		repository.save(topico);
		
		var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalheTopico(topico));
	}
	
	public ResponseEntity<Page<DadosListagemTopico>> listar(Pageable paginacao, String search) {
		if(search != "") {
			return ResponseEntity.ok(repository.findByTitle(search, paginacao).map(DadosListagemTopico::new));
		}
		
		return ResponseEntity.ok(repository.findAll(paginacao).map(DadosListagemTopico::new));
	}
	
	public ResponseEntity<Optional<DadosListagemTopico>> detalhe(Long id) {
		var topico = repository.findById(id).map(DadosListagemTopico::new);
		return ResponseEntity.ok(topico);
	}
	
	public ResponseEntity atualizar(DadosCadastroTopico dados, Long id) {
		var topico = repository.getReferenceById(id);
		topico.atualizarInfo(dados);
		
		return ResponseEntity.ok(new DadosDetalheTopico(topico));
	}
	
	public ResponseEntity deletar(Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
