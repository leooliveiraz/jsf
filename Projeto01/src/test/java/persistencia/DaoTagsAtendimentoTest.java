package persistencia;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import entidades.TagsAtendimento;
import util.HibernateUtil;

public class DaoTagsAtendimentoTest {

	@Test
	public void test() {
		try{
			Session session = HibernateUtil.getSession();
			DaoTagsAtendimento dao = new DaoTagsAtendimento(TagsAtendimento.class, session);
			TagsAtendimento tag = dao.buscaPorAtendimento(session, 37);
			System.out.println("teste");
		}catch(Exception e){
			e.printStackTrace();
			fail("Not yet implemented");
		}
	}

}
