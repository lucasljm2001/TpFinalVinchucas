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

	@Override
	public void actualizarResultado(Muestra muestra) {
		muestra.setResultadoActual(this.ultimoTipoDeOpinion(muestra));		
	}

	public TipoDeOpinion ultimoTipoDeOpinion(Muestra muestra) {
		return muestra.getHistorial().get(muestra.getHistorial().size() -1).getTipo();
	}

}
