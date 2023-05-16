package aplicacion.sistema;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.zonas.ZonaDeCobertura;

public class SistemaDeVinchuca {
	private List<ZonaDeCobertura> zonas;
	private List<Usuario> usuarios;
	private List<Muestra> muestras;

	public SistemaDeVinchuca() {
		
	}
	
	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
	}

}
