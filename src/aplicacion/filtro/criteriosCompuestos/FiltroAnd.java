package aplicacion.filtro.criteriosCompuestos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.filtro.CriterioCompuesto;
import aplicacion.filtro.Filtro;
import aplicacion.vinchucas.muestra.Muestra;

public class FiltroAnd extends CriterioCompuesto {

	public FiltroAnd() {
		super();
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		List<Muestra> resultado = new ArrayList<Muestra>();
		resultado.addAll(this.getFiltros().get(0).filtrar(muestras));
		this.getFiltros().stream().forEach(f -> resultado.retainAll(f.filtrar(muestras)));
		return resultado;
	}

}
