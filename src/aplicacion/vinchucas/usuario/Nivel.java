package aplicacion.vinchucas.usuario;
import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.OExperto;
import aplicacion.vinchucas.muestra.Opinion;
import aplicacion.vinchucas.muestra.Verificacion;

public abstract class Nivel {
	
	public abstract void actualizarNivel(Usuario usuario);
	
//	Este metodo se utiliza en el constructor de la muestra para que la muestra tenga su nivel. 
	public Verificacion nuevaVerificacion() {
		return new OExperto();
	}
	
	public boolean esExperto(){
		return true;
	} 
	
	public boolean tieneCondicionesDeExperto(Usuario usuario) {
		return usuario.enviosEnLosUltimos30Dias() > 10 && usuario.revisionesEnLosUltimos30Dias() > 20;	
	}
	
	public void actualizarNivelDeUsuario(Usuario usuario,Nivel nivel) {
		usuario.setNivel(nivel);
	}
	
	
	public void  modificarMuestra(Muestra m, Opinion o) {
		m.votadaPorExperto(o);
	}
}
