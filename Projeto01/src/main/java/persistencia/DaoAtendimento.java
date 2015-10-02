package persistencia;

import org.hibernate.Session;

import entidades.Atendimento;

public class DaoAtendimento extends GenericDao<Atendimento>{

	public DaoAtendimento(Class<Atendimento> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
