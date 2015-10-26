package persistencia;

import java.io.Serializable;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entidades.Tags;
import entidades.TagsAtendimento;

public class DaoTagsAtendimento extends GenericDao<TagsAtendimento> {

	public DaoTagsAtendimento(Class<TagsAtendimento> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	
	public TagsAtendimento buscaPorAtendimento(Session session, int cdAtendimento){
		try{
			
				Criteria criterio = session.createCriteria(TagsAtendimento.class);
				criterio.add(Restrictions.eq("snAtivo", "S"));
				criterio.add(Restrictions.eq("atendimentoCdAtendimento", cdAtendimento));
				TagsAtendimento tag = (TagsAtendimento) criterio.uniqueResult();
				return tag;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
	}

}
