package persistencia;

import org.hibernate.Session;

import entidades.SetorHasAtendimento;

public class DaoSetorHasAtendimento extends GenericDao<SetorHasAtendimento>{

	public DaoSetorHasAtendimento(Class<SetorHasAtendimento> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
