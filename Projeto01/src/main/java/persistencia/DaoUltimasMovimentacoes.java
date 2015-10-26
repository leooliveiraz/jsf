package persistencia;

import org.hibernate.Session;

import entidades.UltimasMovimentacoes;

public class DaoUltimasMovimentacoes extends GenericDao<UltimasMovimentacoes>{

	public DaoUltimasMovimentacoes(Class<UltimasMovimentacoes> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
}
