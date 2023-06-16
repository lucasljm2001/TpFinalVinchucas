package aplicacion.filtro.criteriosSimples;

import java.time.LocalDate;
import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public interface CriterioFecha {
	public boolean comparar(Muestra muestra, LocalDate fecha);
}
