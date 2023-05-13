package aplicacion.vinchucas.muestra;

public class Verificada extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion) {
		// nadie puede opinar sobre muestras verificadas
	}
	
	@Override
	public boolean esVerificada() {
		return true;
	}


}
