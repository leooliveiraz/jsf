package persistencia;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.TipoAlerta;

public class TipoAlertaDaoTest {

	@Test
	public void testGenericDao() {
		fail("Not yet implemented");
	}

	@Test
	public void testSalvar() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try{
			TipoAlerta tipoAlerta = new TipoAlerta(4,"OCORRENCIA");
			DaoTipoAlerta dao = new DaoTipoAlerta(TipoAlerta.class, session);
			dao.salvar(tipoAlerta);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
		}


	}

	@Test
	public void testAtualizar() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try{
			TipoAlerta tipoAlerta = new TipoAlerta(3,"PERDA2");
			DaoTipoAlerta dao = new DaoTipoAlerta(TipoAlerta.class, session);
			dao.atualizar(tipoAlerta);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			session.close();
			fail("Not yet implemented");
		}

	}

	@Test
	public void testDelete() {
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		try{
			TipoAlerta tipoAlerta = new TipoAlerta(3,"PERDA2");
			DaoTipoAlerta dao = new DaoTipoAlerta(TipoAlerta.class, session);
			dao.delete(tipoAlerta);
			session.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented");
		}finally{
			session.close();
		}
	}

	@Test
	public void testBuscaPorId() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscaPaginada() {
		fail("Not yet implemented");
	}

	@Test
	public void testBuscaTodos() {
		fail("Not yet implemented");
	}

}
