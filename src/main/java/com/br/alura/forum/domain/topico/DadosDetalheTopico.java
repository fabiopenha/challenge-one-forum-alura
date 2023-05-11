package com.br.alura.forum.domain.topico;

import java.time.LocalDateTime;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalheTopico(
		Long id,
		String titulo, 
		String mensagem,
		LocalDateTime data_criacao, 
		StatusTopico status, 
		Usuario autor,
		Curso curso) {
	
	public DadosDetalheTopico(Topico topico) {
		this(topico.getId(), topico.getTitulo(), topico.getMensagem(), topico.getDataCriacao(), topico.getStatus(), topico.getAutor(), topico.getCurso());
	}
}
