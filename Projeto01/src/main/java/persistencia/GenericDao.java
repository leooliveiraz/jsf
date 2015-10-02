package persistencia;



import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import util.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class GenericDao<T> {
	
	private Class<T> classe;
	private Session session;

	public GenericDao (Class<T> classe,Session session){
		this.classe = classe;
		this.session = session;
	}
	
	public void salvar(T classe){
		this.session.save(classe);
	}

	public void atualizar(T classe){
		this.session.update(classe);
	}

	public void delete(T classe){
		this.session.delete(classe);
	}
	
	public T buscaPorId(Serializable id){
		Criteria criterio = this.session.createCriteria(this.classe);
		criterio.add(Restrictions.eq("id", id));
		return (T) criterio.uniqueResult();
	}
	
	public List<T> buscaPaginada ( int inicio, int fim){
		Criteria criterio = session.createCriteria(this.classe);
		criterio.setFirstResult(inicio);
		criterio.setMaxResults(fim);
		return (List<T>) criterio.list();
	}
	
	public List<T> buscaTodos ( ){
		Criteria criterio = session.createCriteria(this.classe);
		return (List<T>) criterio.list();
	}
	
	
}
