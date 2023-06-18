package aplicacion.vinchucas.muestra;

import java.util.List;
import java.util.stream.Stream;

import aplicacion.sistema.SistemaDeVinchuca;

public class OBasico extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion, SistemaDeVinchuca sistema) {
		// Este if se podria llevar a una clase abstracta y que adentro use un metodo abstracto
		// que implemente cada clase. REVISARRRR
		if (opinion.esOpinionDeExperto()) {
			muestra.setVerificacion(new OExperto());
			}
		muestra.agregarHistorial(opinion);
		// Tiene que ser muestra por que puede ser que haya un cambio de estado
		muestra.actualizarResultado(sistema);
	}
	
	public TVerificacion getValorVerificacion() {
		return TVerificacion.OBASICO;
	}


	@Override
	public void actualizarResultado(Muestra muestra, SistemaDeVinchuca sistema){ 
    //Cacular el tipo de opinion que mas votos tiene y lo defino como resultado actual.		
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
  