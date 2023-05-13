package aplicacion.vinchucas.usuario;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Verificacion;

public class Basico extends Nivel {

	public Basico(Usuario usuario) {
		super(usuario);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void opinar(Muestra muestra) {
		// TODO Auto-generated method stub

	}


	@Override
	public void actualizarNivel() {
		// TODO Auto-generated method stub

	}
	@Override
	public Verificacion nuevaVerificacion() {
		return new OBasico();
	}
	

}
