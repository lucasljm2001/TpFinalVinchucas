package aplicacion.vinchucas.usuario;
import java.util.*;
import java.time.LocalDate;
import aplicacion.vinchucas.*;
import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.zona.Ubicacion;

public class Usuario {
	private List<LocalDate> envios;
	private List <LocalDate> revisiones;
	private Nivel nivel;
	private String id; // preguntar y agregar al UML
	
	public Usuario(String id) {
		this.id = id;
		this.nivel = new Basico(this);
	}
	
	public Usuario(String id, Nivel nivel) {
		this(id);
		this.nivel = nivel;
	}
	
	public void opinar(Muestra muestra) {
		
	}
	
	
	public void enviar(String foto, Ubicacion ubicacion) {
		
	}
	
	public void actualizarNivel() {
		
	}

	public Nivel getNivel() {
		return nivel;
	}
}
