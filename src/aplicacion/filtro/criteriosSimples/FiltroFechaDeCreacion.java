package aplicacion.filtro.criteriosSimples;

import java.time.LocalDate;
import java.util.List;

import aplicacion.filtro.CriterioSimple;
import aplicacion.vinchucas.muestra.Muestra;

public class FiltroFechaDeCreacion implements CriterioSimple {
	private LocalDate fecha;
	
	public FiltroFechaDeCreacion(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.getFecha().equals(fecha)).toList();
	}

}
