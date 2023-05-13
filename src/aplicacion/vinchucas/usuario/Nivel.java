package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.OExperto;
import aplicacion.vinchucas.muestra.Verificacion;

public abstract class Nivel {
	private Usuario usuario;
	
	public abstract void opinar(Muestra muestra);
	public abstract void actualizarNivel();
	
	
	public Nivel(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public Verificacion nuevaVerificacion() {
		return new OExperto();
	}
	
	
	
}
