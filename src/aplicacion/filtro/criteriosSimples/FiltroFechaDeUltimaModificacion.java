package aplicacion.filtro.criteriosSimples;

import java.time.LocalDate;
import java.util.List;

import aplicacion.filtro.CriterioSimple;
import aplicacion.vinchucas.muestra.Muestra;

public class FiltroFechaDeUltimaModificacion implements CriterioSimple{
	private CriterioFecha criterio;
	private LocalDate fecha;
	
	
	public FiltroFechaDeUltimaModificacion(CriterioFecha criterio, LocalDate fecha) {
		this.criterio = criterio;
		this.fecha = fecha;
	}


	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> this.criterio.comparar(m,fecha)).toList();
	}

}
