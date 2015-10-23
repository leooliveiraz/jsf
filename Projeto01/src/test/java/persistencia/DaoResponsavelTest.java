package persistencia;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.Responsavel;

public class DaoResponsavelTest {

	@Test
	public void testSalvar() {
		try{
			Responsavel responsavel = new Responsavel();
			responsavel.setNmResponsavel("LEANDRO");
			responsavel.setCelular1("91088011");
			responsavel.setCelular2("91088012");
			responsavel.setTelefone("91088013");
			responsavel.setTelefoneComercial("91088013");
			responsavel.setEmail("LEANDRO@UOL.COM.BR");
			responsavel.setCpf("78945612321");
			
			Session session = HibernateUtil.getSession();
			DaoResponsavel dao = new DaoResponsavel(Responsavel.class, session);
			session.beginTransaction();
			dao.salvar(responsavel);
			session.getTransaction().commit();
			session.close();			
			
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented");			
		}
	}

}
