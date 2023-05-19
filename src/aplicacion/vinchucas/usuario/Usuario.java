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
	private SistemaDeVinchuca sistema;
	
	public Usuario() {
		this.inicializarFechas();
	}

	public Usuario(String id) {
		this.id = id;
		this.nivel = new Basico(); 
		this.inicializarFechas();
	}
		
	public Usuario(String id, SistemaDeVinchuca sistema) {
		this(id);
		this.sistema = sistema;
	}

	private void inicializarFechas() {
		this.fechasEnvios = new ArrayList<>();
		this.fechasRevisiones = new ArrayList<>();
	}
	
	public void opinar(Muestra muestra, TipoDeOpinion tipoOpinion) {
		fechasRevisiones.add(LocalDate.now());
		Opinion opinion = new Opinion(tipoOpinion, this.nivel, this);
		this.nivel.opinar(muestra, opinion);
	}
	
	public void enviar(String foto, Ubicacion ubicacion, TipoDeOpinion opinion) {
		Muestra muestra = new Muestra(foto, this, ubicacion, opinion, LocalDate.now());
		sistema.agregarMuestra(muestra);
		fechasEnvios.add(LocalDate.now());
		this.actualizarNivel();
	}
	
	public void actualizarNivel() {
		this.nivel.actualizarNivel(this);
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
		fechasRevisiones.add(LocalDate.now());
	}
	
	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public int enviosEnLosUltimos30Dias() {
		return fechasEnvios.stream().filter(f->f.isAfter(LocalDate.now().minusDays(30))).toList().size();
	}
	
	public int revisionesEnLosUltimos30Dias() {
		return fechasRevisiones.stream().filter(f->f.isAfter(LocalDate.now().minusDays(30))).toList().size();
	}

	public void setFechasEnvios(List<LocalDate> fechasEnvios) {
		this.fechasEnvios = fechasEnvios;
	}
	
}
