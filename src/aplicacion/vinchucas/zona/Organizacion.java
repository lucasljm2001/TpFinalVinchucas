package aplicacion.vinchucas.zona;

import aplicacion.vinchucas.muestra.Muestra;

public class Organizacion { //OBSERVER
	private Ubicacion ubicacion;
	private FuncionalidadExterna nuevaMuestra;
	private FuncionalidadExterna validacion;
	private TipoDeOrganizacion tipo;
	private int cantidadDeEmpleados;
	
	public Organizacion(Ubicacion ubicacion, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacion,TipoDeOrganizacion tipo, int cantidadDeEmpleados) {
		
		this.ubicacion = ubicacion;
		this.nuevaMuestra = nuevaMuestra;
		this.validacion = validacion;
		this.tipo = tipo;
		this.cantidadDeEmpleados = cantidadDeEmpleados;
	}

	public void registrarseEnUnaZona(ZonaDeCobertura zona) {
		zona.registrar(this);
	}

	public void funcionalidadNuevaMuestra(Muestra muestra, ZonaDeCobertura zonaDeCobertura) {
		 nuevaMuestra.nuevoEvento(muestra, this, zonaDeCobertura);
	}

	public void funcionalidadValidacion(Muestra muestra, ZonaDeCobertura zonaDeCobertura) {
		 validacion.nuevoEvento(muestra, this, zonaDeCobertura);
	}
	
	public void eliminarRegistros(ZonaDeCobertura zona) {
		zona.sacar(this);
	}
}
