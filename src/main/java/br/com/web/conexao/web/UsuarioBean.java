package br.com.web.conexao.web;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.web.conexao.usuario.Usuario;

@ManagedBean(name="usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public String getConfirmarSenha() {
		return confirmarSenha;
	}
	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}
	
	@PostConstruct
	public void testeProst() {
		
		System.out.print("Post\n");
	}
	
	@PreDestroy
	public void testeDestroy() {
		
		System.out.print("Destroy\n");
	}

}
