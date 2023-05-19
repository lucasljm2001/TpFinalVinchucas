package aplicacion.filtro;

import java.util.ArrayList;
import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public class FiltroAnd extends CriterioCompuesto {

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		List<Muestra> resultado = new ArrayList<Muestra>();
		resultado.addAll(this.getFiltros().get(0).filtrar(muestras));
		resultado.retainAll(this.getFiltros().get(1).filtrar(muestras)); //chequear
		return resultado;
	}

}
