package aplicacion.filtro;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public interface CriterioSimple extends Filtro {
	public List<Muestra> filtrar(List<Muestra>muestras);
}
