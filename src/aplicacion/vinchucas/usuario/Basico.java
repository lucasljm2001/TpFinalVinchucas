package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.OBasico;
import aplicacion.vinchucas.muestra.Opinion;
import aplicacion.vinchucas.muestra.Verificacion;

public class Basico extends Nivel {

	@Override
	public void actualizarNivel(Usuario usuario) {
		if(this.tieneCondicionesDeExperto(usuario)) {
			this.actualizarNivelDeUsuario(usuario, new Experto());
		}
	}
	
	@Override
	public Verificacion nuevaVerificacion() {
		return new OBasico();
	}
	
	@Override
	public boolean esExperto(){
		return false;
	} 
	
}
