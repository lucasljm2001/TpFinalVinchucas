package aplicacion.vinchucas.muestra;

import aplicacion.sistema.SistemaDeVinchuca;

public class Verificada extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion, SistemaDeVinchuca sistema) {
		// No tiene comportamiento porque no es posible que un USUARIO opine sobre muestras ya verificadas.
	}
	
	@Override
	public boolean esVerificada() {
		return true;
	}
	
	public TVerificacion getValorVerificacion() {
		return TVerificacion.VERIFICADA;
	}


	@Override
	public void actualizarResultado(Muestra muestra, SistemaDeVinchuca sistema) {
		muestra.setResultadoActual(this.ultimoTipoDeOpinion(muestra));		
	}

	public TipoDeOpinion ultimoTipoDeOpinion(Muestra muestra) {
		return muestra.getHistorial().get(muestra.getHistorial().size() -1).getTipo();
	}

}
