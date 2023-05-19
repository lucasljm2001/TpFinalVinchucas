package aplicacion.filtro.criteriosSimples.fechas;

import java.time.LocalDate;
import java.util.List;

import aplicacion.filtro.criteriosSimples.CriterioFecha;
import aplicacion.vinchucas.muestra.Muestra;

public class FechaPosterior implements CriterioFecha {

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras, LocalDate fecha) {
		return muestras.stream()
				.filter(m -> m.ultimaModificacion().isAfter(fecha)).toList();
	}

}
