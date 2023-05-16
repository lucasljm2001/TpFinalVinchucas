package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.OBasico;
import aplicacion.vinchucas.muestra.Opinion;
import aplicacion.vinchucas.muestra.Verificacion;

public class Basico extends Nivel {
	
	
	public Basico(Usuario usuario) {
		super(usuario);
	}

	@Override
	public void actualizarNivel() {
		// TODO Auto-generated method stub
		// si hizo mas de x opiniones y subida x fotos sube de nivel a Experto.
		if(this.tieneCondicionesDeExperto()) {
			this.actualizarNivelDeUsuario(new Experto(this.getUsuario()));
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
