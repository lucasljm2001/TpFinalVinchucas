package aplicacion.filtro;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public class FiltroOr extends CriterioCompuesto {


	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return filtros.get(0).filtrar(muestras).
		
	}

}
