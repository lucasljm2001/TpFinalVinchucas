package aplicacion.vinchucas.muestra;

import java.util.*;

import aplicacion.sistema.SistemaDeVinchuca;
import aplicacion.vinchucas.zona.Funcionalidad;

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
		Map<Integer, TipoDeOpinion> cantTipo = this.numeroDeOpinionesPorTipo(opiniones);
		boolean algunaOpinionConDos = cantTipo.keySet().stream().anyMatch(i -> i>1);
		if(opiniones.size()==1) {
			muestra.setResultadoActual(opiniones.get(0).getTipo());
		}
		else if (!algunaOpinionConDos) {
			muestra.setResultadoActual(TipoDeOpinion.NODEFINIDO);
			
		}
		else {
			muestra.setResultadoActual(cantTipo.get(2));
		}
	} 
	
	private Map<Integer,TipoDeOpinion> numeroDeOpinionesPorTipo(List<Opinion> opiniones){
		Map<Integer, TipoDeOpinion> cantTipo = new HashMap<Integer, TipoDeOpinion>();
		for (Opinion opinion : opiniones) {
			Integer actual = opiniones.stream().filter(o -> o.getTipo()==opinion.getTipo()).toList().size();
			cantTipo.put(actual, opinion.getTipo());
		}
			return cantTipo;
	}
	
	

}
