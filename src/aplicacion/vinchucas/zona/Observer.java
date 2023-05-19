package aplicacion.vinchucas.zona;

import aplicacion.vinchucas.muestra.Muestra;

public interface Observer {
	
	public void registrarse(ZonaDeCobertura zona);
	
	public void eliminarse(ZonaDeCobertura zona);

	public void funcionalidad(Muestra muestra, ZonaDeCobertura zonaDeCobertura, Funcionalidad funcionalidad);
	
}
