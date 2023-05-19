package aplicacion.vinchucas.muestra;

public abstract class Verificacion {
		
	public abstract void opinar(Muestra muestra, Opinion opinion);
	
	public boolean esVerificada() {
		return false;
	}

	public abstract void actualizarResultado(Muestra muestra);

}
