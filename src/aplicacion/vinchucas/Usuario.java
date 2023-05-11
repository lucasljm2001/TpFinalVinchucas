package aplicacion.vinchucas;
import java.util.*;
import java.time.LocalDate;

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
	
	public void verificar(Muestra muestra) {
		
	}
	
	public void enviar(String foto, Ubicacion ubicacion) {
		
	}
	
	public void actualizarNivel() {
		
	}
}
