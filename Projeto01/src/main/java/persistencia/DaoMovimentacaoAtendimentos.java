package persistencia;

import java.util.List;




import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;

import entidades.MovimentacaoAtendimentos;

public class DaoMovimentacaoAtendimentos extends GenericDao<MovimentacaoAtendimentos> {

	public DaoMovimentacaoAtendimentos(Class<MovimentacaoAtendimentos> classe,
			Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	
    public List<MovimentacaoAtendimentos> consultar(Session session){  
        String query = "SELECT entidade.MovimentacaoAtendimentos(u.cd_tag_atendimento, u.antenas_cd_antena, u.cd_movimentacao,u.dt_movimentacao) FROM UltimasMovimentacoes u";  
       
        Query hql = session.createQuery(query);  
        hql.setResultTransformer(Transformers.aliasToBean(MovimentacaoAtendimentos.class)); 
        
        return hql.list();  
      }  
 
}
