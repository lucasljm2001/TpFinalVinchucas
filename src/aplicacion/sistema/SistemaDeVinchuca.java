package aplicacion.sistema;

import java.util.List;
import java.util.*;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.TipoDeOpinion;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.Funcionalidad;
import aplicacion.vinchucas.zona.Ubicacion;
import aplicacion.vinchucas.zona.ZonaDeCobertura;

public class SistemaDeVinchuca {
	private List<ZonaDeCobertura> zonas;
	private List<Muestra> muestras;

	public SistemaDeVinchuca() {
		this.zonas = new ArrayList<ZonaDeCobertura>();
		this.muestras= new ArrayList<Muestra>();
	}

	public SistemaDeVinchuca(List<ZonaDeCobertura> zonas, List<Muestra> muestras) {
		this.zonas = zonas;
		this.muestras = muestras;
	}

	public List<Muestra> getMuestras() {
		return muestras; 
	}
	
	public List<ZonaDeCobertura> getZonas() {
		return zonas;
	}
	
	public void usuarioEnviarMuestra(Usuario usuario, String foto, Ubicacion ubicacion, TipoDeOpinion opinion) {
		usuario.enviar(foto, ubicacion, opinion, this);
	}

	public void agregarMuestra(Muestra muestra) {
		this.getMuestras().add(muestra);
	} 
	
	public List<Muestra> todasLasMuestrasAMenosDe(Muestra muestra, double distancia){
		return this.getMuestras().stream()
				.filter(m -> m.getUbicacion()
						.calcularDistancia(muestra.getUbicacion()) < distancia && m != muestra).toList();
	}
	
	public List<ZonaDeCobertura> zonasSolapadas (ZonaDeCobertura zona){
		return this.getZonas().stream()
				.filter(z-> z.esZonaSolapada(zona) && z != zona).toList(); 
	}
	
	public List<Muestra> muestrasDeZona(ZonaDeCobertura zona){
		return this.getMuestras().stream()
				.filter(m-> zona.ubicacionEstaEnElRango(m.getUbicacion())).toList();
	}
	
	public void notificarCambioALasZonas(Muestra muestra, Funcionalidad funcionalidad) {
		this.getZonas().stream().filter(z -> this.muestrasDeZona(z).contains(muestra)).forEach(z -> z.notificar(muestra,funcionalidad));
	}
	
	
}
