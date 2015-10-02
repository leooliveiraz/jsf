package persistencia;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.Alertas;
import entidades.AlertasId;

public class DaoAlertasIdTest {

	@Test
	public void testSalvar() {
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			AlertasId dto = new AlertasId();
			GenericDao<AlertasId> dao = new GenericDao<AlertasId>(AlertasId.class,session);		
			dao.salvar(dto);
			System.out.println("Salvo" + dto);
			session.getTransaction().commit();
			session.close();
		}
		catch(Exception e){
			System.out.println(e.getMessage()+",\n"+e.getCause());
			//e.printStackTrace();
			fail("Erro ao Salvar");
		}
	}

	@Test
	public void testAtualizar() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
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
