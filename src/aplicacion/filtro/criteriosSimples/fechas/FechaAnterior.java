package aplicacion.filtro.criteriosSimples.fechas;

import java.time.LocalDate;
import java.util.List;

import aplicacion.filtro.criteriosSimples.CriterioFecha;
import aplicacion.vinchucas.muestra.Muestra;

public class FechaAnterior implements CriterioFecha {

	@Override
	public boolean comparar(Muestra muestra, LocalDate fecha) {
		return muestra.ultimaModificacion().isBefore(fecha);
	}

}
