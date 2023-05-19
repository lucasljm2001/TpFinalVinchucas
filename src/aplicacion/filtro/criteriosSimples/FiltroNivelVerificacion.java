package aplicacion.filtro.criteriosSimples;

import java.util.List;

import aplicacion.filtro.CriterioSimple;
import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.Verificacion;
import aplicacion.vinchucas.usuario.Nivel;

public class FiltroNivelVerificacion implements CriterioSimple {
	private Verificacion verificacion;
	
	public FiltroNivelVerificacion(Verificacion verificacion) {
		this.verificacion = verificacion;
	}

	@Override
	public List<Muestra> filtrar(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.getVerificacion() == verificacion).toList();
	}

}
