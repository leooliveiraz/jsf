package persistencia;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.Atendimento;

public class DaoAtendimentoTest {

	@Test
	public void cadastraAtendimento(){
		Date dt_atendimento = new Date();
		Atendimento atendimento = new Atendimento(1,dt_atendimento, "LPROCHA");
		Session session = new HibernateUtil().getSession();
		DaoAtendimento dao = new DaoAtendimento(Atendimento.class, session);
		session.beginTransaction();
		dao.salvar(atendimento);
		session.getTransaction().commit();
		session.close();		
	}
	@Test
	public void busca(){
		try{
			Session session = new HibernateUtil().getSession();
			DaoAtendimento dao = new DaoAtendimento(Atendimento.class, session);
			Atendimento atendimento =(Atendimento) dao.buscaUltimoRegistro(session);
			session.close();
			System.out.println(atendimento.getCdAtendimento());		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	@Test
	public void semAlta(){
		try{
			Session session = new HibernateUtil().getSession();
			DaoAtendimento dao = new DaoAtendimento(Atendimento.class, session);
			List<Atendimento> lista = dao.buscaAtendimentosSemAlta(session);
			for(int i=0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdAtendimento());
			}
		}
		catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}



}
