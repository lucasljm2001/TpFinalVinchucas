package aplicacion.vinchucas.muestra;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.Ubicacion;

public class Muestra {

		private String foto;
		private Usuario usuario;
		private Ubicacion ubicacion;
		private TipoDeOpinion resultadoActual;
		private List<Opinion> historial;
		private LocalDate fecha;
		private Verificacion verificacion;
		
		
		public Muestra(String foto, Usuario usuario, Ubicacion ubicacion, TipoDeOpinion resultadoActual,LocalDate fecha) {
			LocalDate hoy = LocalDate.now();
			this.foto = foto;
			this.usuario = usuario;
			this.ubicacion = ubicacion;
			this.resultadoActual = resultadoActual;
			this.fecha = hoy;
			historial = new ArrayList<Opinion>();
			verificacion = usuario.getNivel().nuevaVerificacion();
		}


		public Verificacion getVerificacion() {
			return verificacion;
		}

		public void agregarHistorial(Opinion opinion) {
			historial.add(opinion);
		}

		public void setVerificacion(Verificacion verificacion) {
			this.verificacion = verificacion;
			
		}

		public boolean dosExpertosOpinaronIgual(Opinion opinion) {
			return historial.stream().filter(op -> op.esOpinionDe().esExperto()).anyMatch(op-> op.getTipo() == opinion.getTipo());
			
		}
		
		
	

		
}
