package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.UltimasMovimentacoes;

public class DaoUltimasMovimentacoesTest {

	@Test
	public void test() {
		try{
			List<UltimasMovimentacoes> lista;
			Session session = HibernateUtil.getSession();
			DaoUltimasMovimentacoes dao = new DaoUltimasMovimentacoes(UltimasMovimentacoes.class, session);
			lista = dao.buscaTodos();
			for(int i=0;i<lista.size();i++){
				System.out.println(lista.get(i).getCdAtendimento()+" "+lista.get(i).getNmPaciente());
			}
		}catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

}
