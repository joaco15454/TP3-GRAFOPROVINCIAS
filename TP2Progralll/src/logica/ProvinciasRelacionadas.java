package logica;

import java.util.HashSet;
import java.util.Set;

public class ProvinciasRelacionadas {
	private  String prov1;
	private  String prov2;
	private int peso;
	
	public ProvinciasRelacionadas (String  prov1 , String prov2, int peso) {
		
		prov1=prov1;
		prov2=prov2;
		peso=peso;
		
		}
	
	public String getProv1() {
		return this.prov1;
	}
	
	public  String getProv2() {
		return this.prov2;
	}
	
	public int getPeso() {
		return this.peso;
	}

}
