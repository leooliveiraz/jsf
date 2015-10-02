package persistencia;

import org.hibernate.Session;

import entidades.Tags;
import entidades.TagsAtendimentoId;

public class DaoTagsAtendimentoId extends GenericDao<TagsAtendimentoId>  {

	public DaoTagsAtendimentoId(Class<TagsAtendimentoId> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
