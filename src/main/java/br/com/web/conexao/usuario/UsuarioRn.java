package br.com.web.conexao.usuario;

import java.util.List;

import br.com.web.conexao.util.DaoFactory;

public class UsuarioRn {
	
	private UsuarioDao usuarioDao;
	
	public UsuarioRn() {
		this.usuarioDao = DaoFactory.criarUsuarioDao();
	}
	
	public Usuario carregar(Integer codigo) {
		return this.usuarioDao.carregar(codigo);
	}
	
	public Usuario buscarPorLogin(String login) {
		return this.usuarioDao.buscarPorLogin(login);
	}
	
	public void salvar(Usuario usuario) {
		Integer codigo = usuario.getCodigo();
		
		if(codigo == null || codigo == 0){
			this.usuarioDao.salvar(usuario);
			
		}else {
			this.usuarioDao.atualizar(usuario);
		}
	}
	
	public void excluir(Usuario usuario) {
		
		this.usuarioDao.exlcuir(usuario);
	}
	
	public List<Usuario> listar(){
		
		return this.usuarioDao.listar();
	}

}
