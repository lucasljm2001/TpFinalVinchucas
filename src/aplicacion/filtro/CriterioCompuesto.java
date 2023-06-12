package aplicacion.filtro;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;
import java.util.*;

public abstract class CriterioCompuesto implements Filtro{
	private List<Filtro> filtros;
	
	public CriterioCompuesto() {
		this.filtros = new ArrayList<Filtro>();
	}

	public abstract List<Muestra> filtrar(List<Muestra>muestras);
	
	public void agregarFiltro(Filtro filtro) {
		this.getFiltros().add(filtro);
	}
	
	public void eliminarFiltro(Filtro filtro) {
		this.getFiltros().remove(filtro);
	}

	public List<Filtro> getFiltros() {
		return filtros;
	}
} 
