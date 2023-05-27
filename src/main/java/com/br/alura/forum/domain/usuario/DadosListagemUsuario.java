package com.br.alura.forum.domain.usuario;

import java.time.LocalDateTime;

import com.br.alura.forum.domain.curso.Curso;
import com.br.alura.forum.domain.topico.StatusTopico;
import com.br.alura.forum.domain.topico.Topico;

public record DadosListagemUsuario(String nome, String email) {
	public DadosListagemUsuario(Usuario usuario ) {
		this(usuario.getNome(), usuario.getEmail());
	}
	
	
}
