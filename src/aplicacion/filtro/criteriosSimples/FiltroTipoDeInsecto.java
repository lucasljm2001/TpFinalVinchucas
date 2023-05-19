package aplicacion.filtro.criteriosSimples;

import java.util.List;

import aplicacion.filtro.CriterioSimple;
import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.TipoDeOpinion;

public class FiltroTipoDeInsecto implements CriterioSimple {
	private TipoDeOpinion tipo;
	
	public FiltroTipoDeInsecto(TipoDeOpinion tipo) {
		this.tipo = tipo;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.getResultadoActual() == tipo).toList();
	}

}
