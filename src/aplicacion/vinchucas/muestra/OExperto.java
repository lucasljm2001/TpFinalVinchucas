package aplicacion.vinchucas.muestra;

import java.util.List;

public class OExperto extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion) {
		if (opinion.esOpinionDe().esExperto()) {
			muestra.agregarHistorial(opinion);
		} 
		if (muestra.dosExpertosOpinaronIgual(opinion)) {
			muestra.setVerificacion(new Verificada());
		}
		this.actualizarResultado(muestra);
	}

	@Override
	public void actualizarResultado(Muestra muestra) {
		List<Opinion> opiniones = muestra.getHistorial().stream().filter(op -> op.esOpinionDe().esExperto()).toList();
		int tipos = opiniones.size();
		if (tipos > 1) {
			muestra.setResultadoActual(TipoDeOpinion.NODEFINIDO);
		} else {
			muestra.setResultadoActual(opiniones.get(0).getTipo());
		}
	}

}
