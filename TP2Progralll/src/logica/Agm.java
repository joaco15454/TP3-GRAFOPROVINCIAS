package logica;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Agm {

	private static Grafo grafo ;
	private static Grafo Arbol;
	private static Set <ProvinciasRelacionadas > lista;
	private static List <Integer> listProv;

	public Agm(Set<ProvinciasRelacionadas> listaInicial, List<Integer> listaProvInicial) {
	    lista = listaInicial;
	    grafo = new Grafo(listaInicial.size());
	    Arbol = null;
	    listProv = listaProvInicial;
	}

	public static void cargarprovincia(ProvinciasRelacionadas p) {

		lista.add(p);
		if(!listProv.contains(p.getProv1()))	{
			listProv.add(p.getProv1());
		}if(!listProv.contains(p.getProv2())) {
			listProv.add(p.getProv2());
		}
		
	}

	 void relaciones() {
		
		  for (ProvinciasRelacionadas x :lista ) {
			 if(listProv.contains(x.getProv1()) && listProv.contains(x.getProv2())){
				 int indiceProv1= listProv.indexOf(x.getProv1());
				 int indiceProv2= listProv.indexOf(x.getProv2());
				 grafo.agregarAristaConPeso(indiceProv1, indiceProv2, x.getPeso());
			 }
				 		
		  }
  }

	 public Grafo ArbolGeneradorMinimo() {
		 	relaciones();
		    Arbol = new Grafo(grafo.tamano()); // Crear un nuevo grafo para el árbol generador mínimo
		    List<Integer> verticesVisitados = new ArrayList<>();
		    verticesVisitados.add(0); // Comenzamos desde el vértice 0
		    
		    while (verticesVisitados.size() < grafo.tamano()) {
		        int minArista = Integer.MAX_VALUE;
		        int verticeMin = -1;
		        
		        // Buscar la arista mínima conectada a los vértices visitados
		        for (Integer vertice : verticesVisitados) {
		            Set<Integer> vecinos = grafo.vecinos(vertice);
		            for (Integer vecino : vecinos) {
		                if (!verticesVisitados.contains(vecino) && grafo.obtenerPeso(vertice, vecino) < minArista) {
		                    minArista = grafo.obtenerPeso(vertice, vecino);
		                    verticeMin = vecino;
		                }
		            }
		        }
		        
		        // Agregar el vértice y la arista mínima al árbol generador mínimo
		        if (verticeMin != -1) {
		            verticesVisitados.add(verticeMin);
		            Arbol.agregarAristaConPeso(verticesVisitados.get(verticesVisitados.size() - 2), verticeMin, minArista);
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
