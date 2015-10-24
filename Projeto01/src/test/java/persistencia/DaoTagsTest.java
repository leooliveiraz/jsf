package persistencia;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.junit.Test;

import entidades.Tags;
import util.HibernateUtil;

public class DaoTagsTest {

	@Test
	public void testBuscaTagsAtivas() {
		try{
			Session session = HibernateUtil.getSession();
			DaoTags dao = new DaoTags(Tags.class, session);
			for (int i = 0;i<dao.buscaTagsAtivas(session).size();i++){
				System.out.println(i);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
