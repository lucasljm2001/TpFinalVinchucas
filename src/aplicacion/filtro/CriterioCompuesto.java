package aplicacion.filtro;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public abstract class CriterioCompuesto implements Filtro{
	private List<Filtro> filtros;
	
	public abstract List<Muestra> filtrar(List<Muestra>muestras);
	
	public void agregarFiltro(Filtro filtro) {
		filtros.add(filtro);
	}
	
	public void eliminarFiltro(Filtro filtro) {
		filtros.remove(filtro);
	}
}
