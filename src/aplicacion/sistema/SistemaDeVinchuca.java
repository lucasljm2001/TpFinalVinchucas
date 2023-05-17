package aplicacion.sistema;

import java.util.List;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.ZonaDeCobertura;

public class SistemaDeVinchuca {
	private List<ZonaDeCobertura> zonas;
	private List<Usuario> usuarios;
	private List<Muestra> muestras;

	public SistemaDeVinchuca() {
		
	}
	
	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void agregarMuestra(Muestra muestra) {
		muestras.add(muestra);
	}

	public List<Muestra> muestrasDeZona(ZonaDeCobertura zona){
		return this.getMuestras().stream().filter(m-> zona.ubicacionEstaEnElRango(m.getUbicacion())).toList();
	}
	
	
}
