package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agm {

	private static Grafo grafo ;
	private static Grafo Arbol;
	private static Set <ProvinciasRelacionadas > lista= new HashSet<>();
	private static List <String> listProv= new ArrayList<>();

	public Agm()
	{
		lista =  new HashSet<>();
		grafo= null;
		 Arbol = null;
	}

	public static void crearGrafo() {
        grafo = new Grafo(lista.size());
        relaciones();

	}

	public static void cargarprovincia(ProvinciasRelacionadas p) {

		lista.add(p);
		if(!listProv.contains(p.getProv1()))	{
			listProv.add(p.getProv1());
		}if(!listProv.contains(p.getProv2())) {
			listProv.add(p.getProv2());
		}
		
	}

	private static  void relaciones() {
		
		  for (ProvinciasRelacionadas x :lista ) {
			 if(listProv.contains(x.getProv1()) && listProv.contains(x.getProv2())){
				 int indiceProv1= listProv.indexOf(x.getProv1());
				 int indiceProv2= listProv.indexOf(x.getProv2());
				 grafo.agregarAristaConPeso(indiceProv1, indiceProv2, x.getPeso());
			 }
				 		
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
					Vertices_visitados.add(arismin);
					Arbol.agregarAristaConPeso(x, arismin, Arbol.obtenerPeso(x, arismin));

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
