package persistencia;

import org.hibernate.Session;

import entidades.Observacoes;

public class DaoObservacoes extends GenericDao<Observacoes>{

	public DaoObservacoes(Class<Observacoes> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
