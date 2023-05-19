package aplicacion.filtro;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.TipoDeOpinion;

public class FiltroTipoDeInsecto implements CriterioSimple {
	private TipoDeOpinion tipo;
	
	
	
	public FiltroTipoDeInsecto(TipoDeOpinion tipo) {
		this.tipo = tipo;
	}



	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		// TODO Auto-generated method stub
		return null;
	}

}
