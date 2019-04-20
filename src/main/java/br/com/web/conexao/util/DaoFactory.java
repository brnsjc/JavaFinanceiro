package br.com.web.conexao.util;

import br.com.web.conexao.HibernateUtil;
import br.com.web.conexao.usuario.UsuarioDao;
import br.com.web.conexao.usuario.UsuarioDaoHibernate;

public class DaoFactory {

	
	public static UsuarioDao criarUsuarioDao() {
		
		UsuarioDaoHibernate usuarioDao = new UsuarioDaoHibernate();
		usuarioDao.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		
		return usuarioDao;
		
	}
	
	
	
}
