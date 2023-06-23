package aplicacion.vinchucas.muestra;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;

import aplicacion.sistema.SistemaDeVinchuca;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.Funcionalidad;
import aplicacion.vinchucas.zona.Ubicacion;

public class Muestra {

		private String foto;
		private Usuario usuario;
		private Ubicacion ubicacion;
		private TipoDeOpinion resultadoActual;
		private List<Opinion> historial;
		private LocalDate fecha;
		private Verificacion verificacion;
		
		public Muestra(String foto, Usuario usuario, Ubicacion ubicacion, TipoDeOpinion resultadoActual) {
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

		void agregarHistorial(Opinion opinion) {
			if(!this.opino(opinion.getUsuario())){
				this.getHistorial().add(opinion);
				opinion.getUsuario().sumarRevision();
			}
		} 

		void setVerificacion(Verificacion verificacion) {
			this.verificacion = verificacion;
		}

		public boolean opino(Usuario us) {
			return this.getHistorial().stream().anyMatch(o->o.getUsuario() == us);
		}
		
		private void opinionPorDefecto(Usuario usuario, TipoDeOpinion topinion) {
			Opinion opinion = new Opinion(topinion, usuario);
			this.getHistorial().add(opinion);
		}
		
		void actualizarResultado(SistemaDeVinchuca sistema) {
			this.getVerificacion().actualizarResultado(this, sistema);
		}

		public List<Opinion> getHistorial() { 
			return historial;
		}

		void setResultadoActual(TipoDeOpinion opAct) {
			this.resultadoActual = opAct;
		}
		
		public TipoDeOpinion getResultadoActual() { 
			return resultadoActual;
		}

		public Ubicacion getUbicacion() {
			return ubicacion;
		}
	
		public void opinar(Opinion opinion, SistemaDeVinchuca sistema) {
			// delegamos al state la opinion realizada
			this.getVerificacion().opinar(this, opinion, sistema);
		}

		public LocalDate getFecha() {
			return this.fecha;
		}

		public LocalDate ultimaModificacion() {
			return this.getHistorial().get(this.getHistorial().size()-1).getFecha();
		}
		
		public TVerificacion getValorVerificacion() {
			return this.getVerificacion().getValorVerificacion();
		}
		
		public void votadaPorExperto(Opinion o) {
			this.getVerificacion().haSidoOpinadaPorExperto(this, o);
		}
		
}
