package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.Antenas;
import entidades.MovimentacaoAtendimentos;
import entidades.UltimasMovimentacoes;

public class DaoUltimasMovimentacoesTest {

	@Test
	public void testBuscaTodos() {
		try{
			List<UltimasMovimentacoes> lista;
			Session session = HibernateUtil.getSession();
			session.beginTransaction();
			
			DaoUltimasMovimentacoes dao = new DaoUltimasMovimentacoes(UltimasMovimentacoes.class, session);
			lista = dao.buscaTodos();
			session.close();
			
			for(int i = 0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdMovimentacao());
			}
		}
		catch(Exception e){
			fail("Not yet implemented");
		}
	}

}
