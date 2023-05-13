package aplicacion.vinchucas.usuario;
import java.util.*;

import java.time.LocalDate;
import aplicacion.vinchucas.*;
import aplicacion.vinchucas.muestra.*;
import aplicacion.vinchucas.zona.Ubicacion;


public class Usuario {
	private List<LocalDate> envios;
	private List <LocalDate> revisiones;
	private Nivel nivel;
	private String id;
	
	public Usuario(String id) {
		this.id = id;
		this.nivel = new Basico(this);
	}
		
	public void opinar(Muestra muestra, TipoDeOpinion tipoOpinion) {
		Opinion opinion = new Opinion(tipoOpinion, this.nivel, this);
		this.nivel.opinar(muestra, opinion);
	}
	
	
	public void enviar(String foto, Ubicacion ubicacion, TipoDeOpinion opinion) {
		
	}
	
	public void actualizarNivel() {
		
	}

	public Nivel getNivel() {
		return nivel;
	}

	public void esExperto() {
		this.nivel = new ExpertoExterno(this);
		
	}
}
