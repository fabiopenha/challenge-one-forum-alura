package com.br.alura.forum.domain.resposta;

import java.time.LocalDateTime;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.Resposta;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

public record DadosListagemResposta(Long id, String mensagem,Topico topico, LocalDateTime data_criacao, Usuario autor, Boolean solucao) {
	public DadosListagemResposta(Resposta resposta) {
		this(resposta.getId(), resposta.getMensagem(), resposta.getTopico(), resposta.getDataCriacao(), resposta.getAutor(), resposta.getSolucao());
	}
	
	
}
