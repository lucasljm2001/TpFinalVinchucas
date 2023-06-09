package aplicacion.vinchucas.muestra;

import aplicacion.sistema.SistemaDeVinchuca;

public abstract class Verificacion {
		
	public abstract void opinar(Muestra muestra, Opinion opinion, SistemaDeVinchuca sistema);
	
	public boolean esVerificada() {
		return false;
	}

	public abstract void actualizarResultado(Muestra muestra, SistemaDeVinchuca sistema);
	
	public abstract TVerificacion getValorVerificacion();
	
	public abstract void haSidoOpinadaPorExperto(Muestra m, Opinion o);

}
