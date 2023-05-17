package aplicacion.vinchucas.muestra;
import java.time.LocalDate;
import aplicacion.vinchucas.usuario.Nivel;
import aplicacion.vinchucas.usuario.Usuario;

public class Opinion {
	
	private LocalDate fecha;
	private TipoDeOpinion opinion;
	private Nivel nivel;
	private Usuario usuario;


	public Opinion(TipoDeOpinion opinion, Nivel nivel, Usuario usuario) {
		this.fecha = LocalDate.now();
		this.opinion = opinion;
		this.nivel = nivel;
		this.usuario = usuario;
	}

	public Nivel esOpinionDe() {
		return nivel;
	}

	public TipoDeOpinion getTipo() {
		return opinion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	

}
