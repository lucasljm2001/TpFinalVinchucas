package aplicacion.vinchucas.usuario;
import java.util.*;

import java.time.LocalDate;

import aplicacion.sistema.SistemaDeVinchuca;
import aplicacion.vinchucas.*;
import aplicacion.vinchucas.muestra.*;
import aplicacion.vinchucas.zona.Ubicacion;


public class Usuario {
	private List<LocalDate> fechasEnvios;
	private List <LocalDate> fechasRevisiones;
	private Nivel nivel;
	private String id;
	
	public Usuario() {
		this.inicializarFechas();
	}

	public Usuario(String id) {
		this();
		this.id = id;
		this.nivel = new Basico(); 
	} 
		
	private void inicializarFechas() {
		this.fechasEnvios = new ArrayList<>();
		this.fechasRevisiones = new ArrayList<>();
	}
	
	public void opinar(Muestra muestra, TipoDeOpinion tipoOpinion) {
		Opinion opinion = new Opinion(tipoOpinion, this.getNivel(), this);
		muestra.opinar(opinion);
		this.actualizarNivel();
	}
	
	public void enviar(String foto, Ubicacion ubicacion, TipoDeOpinion opinion, SistemaDeVinchuca sistema) {
		sistema.agregarMuestra(new Muestra(foto, this, ubicacion, opinion));
		this.enviar();
	}
	
	public void enviar() {
		this.getFechasEnvios().add(LocalDate.now());
		this.actualizarNivel();
	}
	 
	public void actualizarNivel() {
		this.getNivel().actualizarNivel(this);
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void esExperto() {
		this.nivel = new ExpertoExterno();
	}
	
	public String getId() {
		return id;
	}

	public void sumarRevision() {
		this.getFechasRevisiones().add(LocalDate.now());
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int enviosEnLosUltimos30Dias() {
		return this.getFechasEnvios().stream().filter(f->f.isAfter(LocalDate.now().minusDays(30))).toList().size();
	}
	
	public List<LocalDate> getFechasEnvios() {
		return fechasEnvios;
	}

	public int revisionesEnLosUltimos30Dias() {
		return this.getFechasRevisiones().stream().filter(f->f.isAfter(LocalDate.now().minusDays(30))).toList().size();
	}

	public void setFechasEnvios(List<LocalDate> fechasEnvios) {
		this.fechasEnvios = fechasEnvios;
	}

	public List<LocalDate> getFechasRevisiones() {
		return fechasRevisiones;
	}
	
}
