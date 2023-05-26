package com.br.alura.forum.domain.usuario;

import java.time.LocalDateTime;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

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
