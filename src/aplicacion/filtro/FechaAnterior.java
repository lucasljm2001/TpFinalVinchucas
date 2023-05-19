package aplicacion.filtro;

import java.time.LocalDate;
import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;

public class FechaAnterior implements CriterioFecha {
	private LocalDate fecha;
	
	
	
	public FechaAnterior(LocalDate fecha) {
		this.fecha = fecha;
	}



	@Override
	public List<Muestra> filtrar(List<Muestra> muestras, LocalDate fecha) {
		// TODO Auto-generated method stub
		return null;
	}

}
