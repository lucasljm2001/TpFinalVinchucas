package aplicacion.vinchucas.usuario;
import java.util.*;

import java.time.LocalDate;

import aplicacion.sistema.SistemaDeVinchuca;
import aplicacion.vinchucas.*;
import aplicacion.vinchucas.muestra.*;
import aplicacion.vinchucas.zona.Ubicacion;


public class Usuario {
	private List<LocalDate> envios;
	private List <LocalDate> revisiones;
	private Nivel nivel;
	private String id;
	private SistemaDeVinchuca sistema;
	
	

	public Usuario(String id) {
		this.id = id;
		this.nivel = new Basico(this);
		this.envios = new ArrayList<>();
		this.revisiones = new ArrayList<>();
	}
	
		
	public Usuario(String id, SistemaDeVinchuca sistema) {
		this(id);
		this.sistema = sistema;
	}

	public void opinar(Muestra muestra, TipoDeOpinion tipoOpinion) {
		revisiones.add(LocalDate.now());
		Opinion opinion = new Opinion(tipoOpinion, this.nivel, this);
		this.nivel.opinar(muestra, opinion);
		
		
	}
	
	
	public void enviar(String foto, Ubicacion ubicacion, TipoDeOpinion opinion) {
		Muestra muestra = new Muestra(foto, this, ubicacion, opinion, LocalDate.now());
//		sistema.agregarMuestra(muestra);
		envios.add(LocalDate.now());
		this.actualizarNivel();
	}
	
	public void actualizarNivel() {
		this.nivel.actualizarNivel();
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void esExperto() {
		this.nivel = new ExpertoExterno(this);
		
	}
	
	public String getId() {
		return id;
	}

	public void sumarRevision() {
		revisiones.add(LocalDate.now());
		
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int enviosEnLosUltimos30Dias() {
		return envios.stream().filter(f->f.isAfter(LocalDate.now().minusDays(30))).toList().size();
	}
	
	public int revisionesEnLosUltimos30Dias() {
		return revisiones.stream().filter(f->f.isAfter(LocalDate.now().minusDays(30))).toList().size();
	}
}
