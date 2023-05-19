package aplicacion.filtro;

import java.time.LocalDate;
import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public class FechaFechaDeCreacion implements CriterioSimple {
	private LocalDate fecha;
	
	public FechaFechaDeCreacion(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return null;
	}

}
