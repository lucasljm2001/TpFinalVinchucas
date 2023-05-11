package aplicacion.vinchucas;
import java.time.LocalDate;
import java.util.*;

public class Muestra {

		private String foto;
		private Usuario usuario;
		private Ubicacion ubicacion;
		private Especie resultadoActual;
		private List<Opinion> historial;
		private LocalDate fecha;
		private Verificacion verificacion;
		
		
		public Muestra(String foto, Usuario usuario, Ubicacion ubicacion, Especie resultadoActual,LocalDate fecha) {
			LocalDate hoy = LocalDate.now();
			this.foto = foto;
			this.usuario = usuario;
			this.ubicacion = ubicacion;
			this.resultadoActual = null;
			this.fecha = hoy;
			historial = new ArrayList<Opinion>();
		}
		
		public List<Muestra> todasLasDeXMts(){ // necesitamos info de la app? 
			return null;
		}
		
		
}
