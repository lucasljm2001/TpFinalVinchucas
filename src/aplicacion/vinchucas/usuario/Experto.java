package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Opinion;

public class Experto extends Nivel {

	@Override
	public void actualizarNivel(Usuario usuario) {
		if(!this.tieneCondicionesDeExperto(usuario)) {
			this.actualizarNivelDeUsuario(usuario,new Basico());
		}
	}
}
