package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.Antenas;

public class DaoAntenasTest {

	/*@Test
	public void testSalvar() {
		try{
			Antenas antena = new Antenas(1,"BERCARIO 1","192.168.4.2",1);
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoAntenas dao = new DaoAntenas(Antenas.class,session);
			dao.salvar(antena);
			session.getTransaction().commit();
			session.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}*/
	@Test
	public void testBuscar() {
		try{
			List<Antenas> lista;
			Session session = HibernateUtil.getSession();
			session.beginTransaction();

			DaoAntenas dao = new DaoAntenas(Antenas.class,session);
			lista = dao.buscaTodos();			
			session.close();
			
			for (int i = 0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdAntena()+" ");
			}

		}catch(Exception e){
			e.printStackTrace();
		}

	
	}

}
