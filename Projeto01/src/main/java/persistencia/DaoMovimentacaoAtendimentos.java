package persistencia;

import org.hibernate.Session;

import entidades.MovimentacaoAtendimentos;

public class DaoMovimentacaoAtendimentos extends GenericDao<MovimentacaoAtendimentos> {

	public DaoMovimentacaoAtendimentos(Class<MovimentacaoAtendimentos> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
 
}
