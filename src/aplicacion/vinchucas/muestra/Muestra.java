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
			this.opinionPorDefecto(usuario,resultadoActual);
			verificacion = usuario.getNivel().nuevaVerificacion();
		}


		public Verificacion getVerificacion() {
			return verificacion;
		}

		public void agregarHistorial(Opinion opinion) {
			if(!this.opino(opinion.getUsuario())){
			 historial.add(opinion);
			 opinion.getUsuario().sumarRevision();
			 
			 //PREGUNTAR!!
			}
		}

		public void setVerificacion(Verificacion verificacion) {
			this.verificacion = verificacion;
			
		}

		public boolean dosExpertosOpinaronIgual(Opinion opinion) {
			return historial.stream().filter(op -> op.esOpinionDe().esExperto()).anyMatch(op-> op.getTipo() == opinion.getTipo());
			
		}
		
		public boolean opino(Usuario us) {
			return historial.stream().anyMatch(o->o.getUsuario() == us);
		}
		
		private void opinionPorDefecto(Usuario usuario, TipoDeOpinion topinion) {
			Opinion opinion = new Opinion(topinion, usuario.getNivel(), usuario);
			historial.add(opinion);
		}
		
	

		
}
