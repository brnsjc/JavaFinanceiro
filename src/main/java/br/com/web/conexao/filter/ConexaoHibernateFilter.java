package br.com.web.conexao.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import br.com.web.conexao.HibernateUtil;

@WebFilter(urlPatterns = {"*.jsf"})
public class ConexaoHibernateFilter implements Filter{

	private SessionFactory sf;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.sf = HibernateUtil.getSessionFactory();
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Session currentSession =  this.sf.getCurrentSession();
		
		Transaction transaction = null;
		
		try {
			
			transaction = currentSession.beginTransaction();
			chain.doFilter(request, response);
			transaction.commit();
			
				if(currentSession.isOpen()){
					currentSession.close();
				
				}
			
		}catch(Throwable ex){
			
			try {
				if(transaction.isActive()) {
					transaction.rollback();
				}
			}catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
					throw new ServletException(ex);
			}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
