package com.br.alura.forum.domain.usuario;

import java.time.LocalDateTime;

import com.br.alura.forum.modelo.Curso;
import com.br.alura.forum.modelo.StatusTopico;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

public record DadosListagemUsuario(String nome, String email) {
	public DadosListagemUsuario(Usuario usuario ) {
		this(usuario.getNome(), usuario.getEmail());
	}
	
	
}
