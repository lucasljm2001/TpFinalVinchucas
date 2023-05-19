package aplicacion.vinchucas.muestra;

import java.util.List;
import java.util.stream.Stream;

public class OBasico extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion) {
		if (opinion.esOpinionDe().esExperto()) {
			muestra.setVerificacion(new OExperto());
			}
		muestra.agregarHistorial(opinion);
		muestra.actualizarResultado();
	}

	@Override
	public void actualizarResultado(Muestra muestra) {
		List<TipoDeOpinion> tipos = muestra.getHistorial().stream().map(op-> op.getTipo()).toList();
		int max = 0;
		TipoDeOpinion opAct = tipos.get(0);
		for ( TipoDeOpinion tipo : tipos) {
			int actual = tipos.stream().filter(t -> t == tipo).toList().size();
			if (actual > max) {
				opAct = tipo; 
				max = actual;
			} else if (actual == max){
				opAct = TipoDeOpinion.NODEFINIDO;
			}
		}
		muestra.setResultadoActual(opAct);
	}
}
