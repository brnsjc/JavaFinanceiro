package br.com.web.conexao;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {
	
	private static SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		
		
		
		try {
				
				Configuration cfg = new Configuration();
				cfg.configure("hibernate.cfg.xml");
			
				StandardServiceRegistryBuilder registradorServico = new StandardServiceRegistryBuilder();
			
				registradorServico.applySettings(cfg.getProperties());
			
				StandardServiceRegistry servico = registradorServico.build();
			
				return cfg.buildSessionFactory(servico);
			
			
			}catch(Throwable e) {
					System.out.print(e);
					throw new ExceptionInInitializerError(e);
				}
			
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
