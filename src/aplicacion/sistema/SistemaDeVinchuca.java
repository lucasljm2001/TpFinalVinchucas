package aplicacion.sistema;

import java.util.List;
import java.util.*;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.ZonaDeCobertura;

public class SistemaDeVinchuca {
	private List<ZonaDeCobertura> zonas;
	private List<Usuario> usuarios;
	private List<Muestra> muestras;

	public SistemaDeVinchuca() {
		this.zonas = new ArrayList<ZonaDeCobertura>();
		this.usuarios = new ArrayList<Usuario>();
		this.muestras= new ArrayList<Muestra>();
	}

	public SistemaDeVinchuca(List<ZonaDeCobertura> zonas, List<Usuario> usuarios, List<Muestra> muestras) {
		this.zonas = zonas;
		this.usuarios = usuarios;
		this.muestras = muestras;
	}

	public List<Muestra> getMuestras() {
		return muestras;
	}
	
	public List<ZonaDeCobertura> getZonas() {
		return zonas;
	}

	public void agregarMuestra(Muestra muestra) {
		this.muestras.add(muestra);
	}
	
	public List<Muestra> todasLasMuestrasAMenosDe(Muestra muestra, double distancia){
		return this.getMuestras().stream()
				.filter(m -> m.getUbicacion()
						.calcularDistancia(muestra.getUbicacion()) < distancia).toList();
	}
	
	public List<ZonaDeCobertura> zonasSolapadas (ZonaDeCobertura zona){
		return this.getZonas().stream()
				.filter(z-> z.esZonaSolapada(zona)).toList();
	}
	
	public List<Muestra> muestrasDeZona(ZonaDeCobertura zona){
		return this.getMuestras().stream()
				.filter(m-> zona.ubicacionEstaEnElRango(m.getUbicacion())).toList();
	}
	
}
