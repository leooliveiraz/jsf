package controle;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Utilitarios;

public class UsuarioControllerTest {

	@Test
	public void test() {
		UsuarioController usu = new UsuarioController();
		usu.setCdUsuario("CV");
		usu.setNmUsuario("nome");
		usu.setDtCadastro(Utilitarios.converteStringData("14/05/1999"));
		usu.setDtNascimento(Utilitarios.converteStringData("14/05/1999"));
		usu.setSenha("AIEAIEHUAHUEAU");
		usu.cadastraUsuario();
	}

}
