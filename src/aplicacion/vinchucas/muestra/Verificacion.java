package aplicacion.vinchucas.muestra;

import aplicacion.sistema.SistemaDeVinchuca;

public abstract class Verificacion {
		
	public abstract void opinar(Muestra muestra, Opinion opinion);
	
	public boolean esVerificada() {
		return false;
	}

	public abstract void actualizarResultado(Muestra muestra);

}
