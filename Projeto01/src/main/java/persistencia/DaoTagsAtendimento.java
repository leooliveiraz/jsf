package persistencia;

import org.hibernate.Session;

import entidades.Tags;
import entidades.TagsAtendimento;

public class DaoTagsAtendimento extends GenericDao<TagsAtendimento> {

	public DaoTagsAtendimento(Class<TagsAtendimento> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
