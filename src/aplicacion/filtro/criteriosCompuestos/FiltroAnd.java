package aplicacion.filtro.criteriosCompuestos;

import java.util.ArrayList;
import java.util.List;

import aplicacion.filtro.CriterioCompuesto;
import aplicacion.vinchucas.muestra.Muestra;

public class FiltroAnd extends CriterioCompuesto {

	public FiltroAnd() {
		super();
	}
	
	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		List<Muestra> resultado = new ArrayList<Muestra>();
		
		for (int i=0; i < this.getFiltros().size()-1; i++) {
			resultado.addAll(this.getFiltros().get(i).filtrar(muestras));
			resultado.retainAll(this.getFiltros().get(i+1).filtrar(muestras));
		}

		return resultado;
	}

}
