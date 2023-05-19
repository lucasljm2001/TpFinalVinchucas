package aplicacion.filtro.criteriosCompuestos;

import java.util.ArrayList;
import java.util.*;
import java.util.HashSet;
import java.util.List;

import aplicacion.filtro.CriterioCompuesto;
import aplicacion.filtro.Filtro;
import aplicacion.vinchucas.muestra.Muestra;

public class FiltroOr extends CriterioCompuesto {

	public FiltroOr() {
		super();
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		List<Muestra> resultado = new ArrayList<Muestra>();
		
		for (Filtro filtro : this.getFiltros()) {
		resultado.addAll(filtro.filtrar(muestras));
		}
		HashSet<Muestra> listaMuestras = new LinkedHashSet<Muestra>(resultado);
		return new ArrayList<>(listaMuestras);
		
	}

}
