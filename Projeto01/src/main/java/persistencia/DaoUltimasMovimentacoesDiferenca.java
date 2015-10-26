package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import entidades.UltimasMovimentacoes;
import entidades.UltimasMovimentacoesDiferenca;

public class DaoUltimasMovimentacoesDiferenca extends GenericDao<UltimasMovimentacoesDiferenca>{

	public DaoUltimasMovimentacoesDiferenca(Class<UltimasMovimentacoesDiferenca> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	
	public List<UltimasMovimentacoesDiferenca> acimaTempo(Session session,int segundos){
		try{
			Criteria criterio = session.createCriteria(UltimasMovimentacoesDiferenca.class);
			criterio.add(Restrictions.sqlRestriction("CD_MOVIMENTACAO not in(SELECT CD_MOVIMENTACAO FROM ALERTAS)"));
			criterio.add(Restrictions.gt("diferenca", segundos));
			return (List<UltimasMovimentacoesDiferenca>) criterio.list();
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		
		
		
	}
}
