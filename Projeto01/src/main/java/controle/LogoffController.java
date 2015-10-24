package controle;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name="logoffController")
@RequestScoped
public class LogoffController {
	
	public String realizaLogoff(){
		try{
			System.out.println("certo");
			FacesContext fc = FacesContext.getCurrentInstance();  
			HttpSession session = (HttpSession)fc.getExternalContext().getSession(false);  
			session.invalidate();
			return "";  
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
			return "";

		}
	}
}
