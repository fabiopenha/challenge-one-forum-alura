package com.br.alura.forum.domain.usuario;

import java.time.LocalDateTime;

import com.br.alura.forum.domain.curso.Curso;
import com.br.alura.forum.domain.topico.StatusTopico;
import com.br.alura.forum.domain.topico.Topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosDetalheUsuario(
		Long id,
		String nome, 
		String email
		) {
	
	public DadosDetalheUsuario(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getEmail());
	}
}
