package com.br.alura.forum.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
import com.br.alura.forum.domain.usuario.DadosAutenticacao;
import com.br.alura.forum.domain.usuario.DadosCadastroUsuario;
import com.br.alura.forum.domain.usuario.DadosListagemUsuario;
import com.br.alura.forum.infra.security.DadosTokenJWT;
import com.br.alura.forum.infra.security.TokenService;
import com.br.alura.forum.modelo.Topico;
import com.br.alura.forum.modelo.Usuario;
import com.br.alura.forum.services.TopicoService;
import com.br.alura.forum.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	@Transactional
	public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados) {
		var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = manager.authenticate(authenticationToken);
		
		var tokenJWT = tokenService.tokenGenerator((Usuario) authentication.getPrincipal());
		return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
	}
}