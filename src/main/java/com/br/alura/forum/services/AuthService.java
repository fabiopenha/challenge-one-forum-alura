package com.br.alura.forum.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.br.alura.forum.domain.topico.DadosCadastroTopico;
import com.br.alura.forum.domain.topico.DadosListagemTopico;
import com.br.alura.forum.domain.topico.TopicoRepository;
import com.br.alura.forum.domain.usuario.DadosCadastroUsuario;
import com.br.alura.forum.domain.usuario.DadosListagemUsuario;
import com.br.alura.forum.domain.usuario.UsuarioRepository;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;

@Service
public class AuthService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("chamou");
		return repository.findByEmail(username);
	}
	
	
}
