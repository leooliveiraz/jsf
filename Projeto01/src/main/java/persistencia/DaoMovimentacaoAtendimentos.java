package persistencia;

import org.hibernate.Session;

import entidades.MovimentacaoPaciente;

public class DaoMovimentacaoAtendimentos extends GenericDao<MovimentacaoPaciente> {

	public DaoMovimentacaoAtendimentos(Class<MovimentacaoPaciente> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
 
}
