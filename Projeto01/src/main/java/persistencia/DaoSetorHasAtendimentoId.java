package persistencia;

import org.hibernate.Session;

import entidades.SetorHasAtendimentoId;

public class DaoSetorHasAtendimentoId extends GenericDao<SetorHasAtendimentoId>{

	public DaoSetorHasAtendimentoId(Class<SetorHasAtendimentoId> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
