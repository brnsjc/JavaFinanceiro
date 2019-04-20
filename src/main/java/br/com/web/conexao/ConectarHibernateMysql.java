package br.com.web.conexao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import br.com.web.conexao.entidades.Categoria;


public class ConectarHibernateMysql {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session sessao = null;
		sessao = HibernateUtil.getSessionFactory().openSession();
		System.out.print("HIBER Conectou !!!");
	
		
		Query consulta = sessao.createQuery("from Categoria c where c.descricao like 'oi%'");
		
		List<Categoria> categorias = consulta.list();
		List<Categoria> cat = new ArrayList<Categoria>();
		List teste = consulta.list();
		//System.out.print(categorias.size());
		
		//System.out.printf("%s",categorias.get(0));
		
		Integer cont = categorias.size();
		
		//System.out.print(categorias.get(0).toString());
	
		cat.addAll(categorias);
		//System.out.print(cat.get(0));
		
		
		
		for (Categoria c : cat) {
		     System.out.println(c.getDescricao().toString());
		     System.out.print(c.getResumo().toString());
		  }
		
		//Categoria cate = (Categoria) consulta.uniqueResult();
		
		//System.out.print(cate);
		
		sessao.clear();
		sessao.close();
	}

}
