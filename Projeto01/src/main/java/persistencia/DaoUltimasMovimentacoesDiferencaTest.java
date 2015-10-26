package persistencia;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import util.HibernateUtil;
import entidades.UltimasMovimentacoesDiferenca;

public class DaoUltimasMovimentacoesDiferencaTest {

	@Test
	public void testAcimaTempo() {
		Session session = HibernateUtil.getSession();
		DaoUltimasMovimentacoesDiferenca dao = new DaoUltimasMovimentacoesDiferenca(UltimasMovimentacoesDiferenca.class, session);
		List<UltimasMovimentacoesDiferenca> lista = dao.acimaTempo(session, 40000);
		for(int i=0;i<lista.size();i++){
			System.out.println(lista.get(i).getCdAtendimento()+" "+lista.get(i).getNmPaciente()+" "+lista.get(i).getCdMovimentacao()+" "+lista.get(i).getDtMovimentacao()+" "+lista.get(i).getDiferenca());
		}
	}
}
