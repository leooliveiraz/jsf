package controle;

import javax.faces.bean.ManagedBean;
@ManagedBean
public class RaulBean {
	String raul = "lalala";

	public String getRaul() {
		return raul;
	}

	public void setRaul(String raul) {
		this.raul = raul;
	}
	
	public int vovo(int l){
		int i=21321;
		i=i-l;
		System.out.println("ó "+ i);
		return i;
		
	}
}
