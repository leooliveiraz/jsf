package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;
import entidades.Atendimento;

public class DaoAtendimento extends GenericDao<Atendimento>{

	public DaoAtendimento(Class<Atendimento> classe, Session session) {
		super(classe, session);
		// TODO Auto-generated constructor stub
	}
	public Atendimento buscaUltimoRegistro( Session session) {
		Criteria crit = session.createCriteria(Atendimento.class);  
		crit.setMaxResults(1); 
		crit.addOrder(Order.desc("cdAtendimento"));
		Atendimento atendimento = (Atendimento) crit.uniqueResult(); 
		
		return atendimento;
		// TODO Auto-generated constructor stub
	}
	
	public List<Atendimento> buscaAtendimentosSemAlta(Session session) {
		Criteria crit = session.createCriteria(Atendimento.class);  
		
		crit.addOrder(Order.asc("cdAtendimento"));
		crit.add(Restrictions.eqOrIsNull("dtAlta", null));
		
		
		return (List<Atendimento>) crit.list(); 
		// TODO Auto-generated constructor stub
	}
	
}
