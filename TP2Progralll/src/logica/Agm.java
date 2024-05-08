package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agm {
	
	private static Grafo grafo ;
	private static Grafo Arbol;
	private static List <ProvinciasRelacionadas > listprov= new ArrayList<>();

	public static void crearGrafo() {
        grafo = new Grafo(listprov.size());
        relaciones();
      	
	}
	
	public static void cargarprovincia(ProvinciasRelacionadas p) {
		
		listprov.add(p);
	}
	
	private static  void relaciones() {
		  for (int i = 0; i < listprov.size(); i++) {
			
	    		grafo.agregarAristaConPeso( listprov.get(i).getProv1(),listprov.get(i).getProv2() , listprov.get(i).getPeso());
		      		
		        
		  }
	}
	
	        
	 public static Grafo ArbolGeneradorMinimo() {
		 crearGrafo();
		 List<Integer>  Vertices_visitados=new ArrayList<>();
		 Vertices_visitados.add(0);
		 Integer vesinomin=null;
		 while  (Vertices_visitados.size()< grafo.tamano()) {
			int arismin= Integer.MAX_VALUE;
			for(Integer x: Vertices_visitados) {
				vesinomin=arismin(x, Vertices_visitados);
			
				if (vesinomin!=null && !Vertices_visitados.contains(vesinomin) && arismin> vesinomin ) 
				{
					arismin=vesinomin;
					Arbol.agregarAristaConPeso(x, arismin, Arbol.obtenerPeso(x, arismin));
					Vertices_visitados.add(arismin);
					}
			}

	
		 } 
		 
		return Arbol; 
}
	
	
	 private static Integer arismin(Integer i, List<Integer> visitados) {
		 Set<Integer> vecinos = grafo.vecinos(i);
		 Integer res = null;
		 Integer min = Integer.MAX_VALUE;
		 for(Integer i1 : vecinos) {
		        	if(min>grafo.obtenerPeso(i,i1) && !visitados.contains(i1)) {
		        		min=grafo.obtenerPeso(i,i1);
		        		res=i1;
		        	
		        }
		 }
		   return res;
	}
	 

	
}
