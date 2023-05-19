package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Opinion;


public class ExpertoExterno extends Nivel {

	@Override
	public void actualizarNivel(Usuario usuario) {
		// los expertos externos no actualizan su nivel, siempre son expertos.
	}

}
