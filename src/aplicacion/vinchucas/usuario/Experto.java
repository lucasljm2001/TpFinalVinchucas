package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Opinion;

public class Experto extends Nivel {

	public Experto(Usuario usuario) {
		super(usuario);
	}


	@Override
	public void actualizarNivel() {
		// if usuario tiene menos de x muestras subidas hace 30 días y menos de x opiniones baja a Basico
		// TO DO
	}

}
