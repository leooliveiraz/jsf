package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import entidades.Tags;

public class DaoTags extends GenericDao<Tags> {

	public DaoTags(Class<Tags> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	public List<Tags> buscaTagsAtivas(Session session) {
		try{
			
			Criteria criterio = session.createCriteria(Tags.class);
			criterio.add(Restrictions.eq("snAtivo", "S"));
			criterio.add(Restrictions.eq("snUso", "N"));
			List<Tags> list = (List<Tags>) criterio.list();
			return  list;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

}
