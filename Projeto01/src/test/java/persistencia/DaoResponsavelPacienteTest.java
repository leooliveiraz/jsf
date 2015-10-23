package persistencia;

import static org.junit.Assert.*;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Test;

import entidades.Responsavel;
import entidades.ResponsavelPaciente;
import util.HibernateUtil;

public class DaoResponsavelPacienteTest {

	@Test
	public void test() {
		Session session = HibernateUtil.getSession();
		DaoResponsavelPaciente dao = new DaoResponsavelPaciente(ResponsavelPaciente.class, session);
	}

}
