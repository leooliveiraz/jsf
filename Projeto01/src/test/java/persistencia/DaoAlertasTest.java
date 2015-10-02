package persistencia;

import static org.junit.Assert.*;

import java.util.Date;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import util.Utilitarios;
import entidades.Alertas;
import entidades.Usuario;

public class DaoAlertasTest {

	

	@Test
	public void testSalvar() {
		try{
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			Alertas dto = new Alertas();
			
			GenericDao<Alertas> dao = new GenericDao<Alertas>(Alertas.class,session);		
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
