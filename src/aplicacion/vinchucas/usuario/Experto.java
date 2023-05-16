package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Opinion;

public class Experto extends Nivel {

	public Experto(Usuario usuario) {
		super(usuario);
	}


	@Override
	public void actualizarNivel() {
		if(!this.tieneCondicionesDeExperto()) {
			this.actualizarNivelDeUsuario(new Basico(this.getUsuario()));
		}
	}

}
