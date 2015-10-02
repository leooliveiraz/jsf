package persistencia;

import org.hibernate.Session;

import entidades.MovimentacaoAtendimentosId;

public class DaoMovimentacaoAtendimentosId extends GenericDao<MovimentacaoAtendimentosId>{

	public DaoMovimentacaoAtendimentosId(
			Class<MovimentacaoAtendimentosId> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}

}
