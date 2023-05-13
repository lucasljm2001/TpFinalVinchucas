package aplicacion.vinchucas.muestra;
import java.time.LocalDate;
import java.util.*;

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
			this.resultadoActual = null;
			this.fecha = hoy;
			historial = new ArrayList<Opinion>();
			verificacion = usuario.getNivel().nuevaVerificacion();
		}


		public Verificacion getVerificacion() {
			return verificacion;
		}
		
	

		
}
