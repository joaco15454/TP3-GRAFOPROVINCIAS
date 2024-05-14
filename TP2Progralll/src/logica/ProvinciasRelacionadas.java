package logica;

public class ProvinciasRelacionadas {
	private  int prov1;
	private  int prov2;
	private int peso;
	
	public ProvinciasRelacionadas (int prov1 , int prov2, int peso) {
		
		this.prov1=prov1;
		this.prov2=prov2;
		this.peso=peso;
		
		}
	
	public int getProv1() {
		return this.prov1;
	}
	
	public  int getProv2() {
		return this.prov2;
	}
	
	public int getPeso() {
		return this.peso;
	}

}
