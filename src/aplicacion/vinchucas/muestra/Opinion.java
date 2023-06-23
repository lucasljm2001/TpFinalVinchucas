package aplicacion.vinchucas.muestra;
import java.time.LocalDate;
import aplicacion.vinchucas.usuario.Nivel;
import aplicacion.vinchucas.usuario.Usuario;

public class Opinion {

	private LocalDate fecha;
	private TipoDeOpinion opinion;
	private Nivel nivel;
	private Usuario usuario;

	public Opinion(TipoDeOpinion opinion, Usuario usuario) {
		this.fecha = LocalDate.now();
		this.opinion = opinion;
		this.nivel = usuario.getNivel();
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

	public LocalDate getFecha() {
		return fecha;
	}
	
	public boolean esOpinionDeExperto() {
		return this.esOpinionDe().esExperto();
	}

	public void modificarMuestra(Muestra m) {
		this.esOpinionDe().modificarMuestra(m, this);
	}
}
