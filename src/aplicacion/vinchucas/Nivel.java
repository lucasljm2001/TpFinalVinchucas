package aplicacion.vinchucas;

public abstract class Nivel {
	private Usuario usuario;
	
	public abstract void opinar(Muestra muestra);
	public abstract void verificar(Muestra muestra);
	public abstract void actualizarNivel();
	
	
	public Nivel(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	
	
}
