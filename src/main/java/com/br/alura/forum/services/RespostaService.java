package com.br.alura.forum.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.util.UriComponentsBuilder;

import com.br.alura.forum.domain.resposta.DadosCadastroResposta;
import com.br.alura.forum.domain.resposta.DadosDetalheResposta;
import com.br.alura.forum.domain.resposta.DadosListagemResposta;
import com.br.alura.forum.domain.resposta.Resposta;
import com.br.alura.forum.domain.resposta.respostaRepository;
import com.br.alura.forum.domain.topico.DadosCadastroTopico;
import com.br.alura.forum.domain.topico.DadosListagemTopico;
import com.br.alura.forum.domain.topico.Topico;

@Service
public class RespostaService {
	
	@Autowired
	private respostaRepository repository;
	
	public ResponseEntity salvar(Resposta resposta, UriComponentsBuilder uriBuilder) {
		repository.save(resposta);
		var uri = uriBuilder.path("/respostas/{id}").buildAndExpand(resposta.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new DadosDetalheResposta(resposta));
	}
	
	public ResponseEntity<Page<DadosListagemResposta>> listar(Pageable paginacao, String search) {
		if(search != "") {
			return ResponseEntity.ok(repository.findByDataCriacao(search, paginacao).map(DadosListagemResposta::new));
		}
		
		return ResponseEntity.ok(repository.findAll(paginacao).map(DadosListagemResposta::new));
	}
	
	public ResponseEntity detalhe(Long id) {
		var resposta = repository.getReferenceById(id);
		
		return ResponseEntity.ok(new DadosDetalheResposta(resposta));
	}
	
	public ResponseEntity atualizar(DadosCadastroResposta dados, Long id) {
		var resposta = repository.getReferenceById(id);
		resposta.atualizarInfo(dados);
		
		return ResponseEntity.ok(new DadosListagemResposta(resposta));
	}
	
	public ResponseEntity deletar(Long id) {
		repository.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
}
