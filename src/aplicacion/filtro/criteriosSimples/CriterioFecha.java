package aplicacion.filtro.criteriosSimples;

import java.time.LocalDate;
import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public interface CriterioFecha {
	public List<Muestra> filtrar(List<Muestra> muestras, LocalDate fecha);
}
