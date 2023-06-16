package aplicacion.filtro.criteriosSimples;

import java.util.List;

import aplicacion.filtro.CriterioSimple;
import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Verificacion;
import aplicacion.vinchucas.usuario.Nivel;

public class FiltroNivelVerificacion implements CriterioSimple {
	private Verificacion verificacion;
	
	public FiltroNivelVerificacion(Verificacion verificacion) {
		this.verificacion = verificacion;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.getValorVerificacion() == verificacion.getValorVerificacion()).toList();
		// Aprobado por el Profesor Diego Cano, lo consultamos en una clase presencial y nos dijo que estaba OK preguntarle 
		// el tipo de clase, ya que es no es un método que usamos recurrentemente, sino sólo en este filtro.
	}

}
