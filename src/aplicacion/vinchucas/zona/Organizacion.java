package aplicacion.vinchucas.zona;

import aplicacion.vinchucas.muestra.Muestra;

public class Organizacion implements Observer{
	private Ubicacion ubicacion;
	private FuncionalidadExterna funcionalidadDeNuevaMuestra;
	private FuncionalidadExterna funcionalidadDeValidacion;
	private TipoDeOrganizacion tipo;
	private int cantidadDeEmpleados;
	
	public Organizacion(Ubicacion ubicacion, FuncionalidadExterna nuevaMuestra, FuncionalidadExterna validacion,TipoDeOrganizacion tipo, int cantidadDeEmpleados) {
		this.ubicacion = ubicacion;
		this.funcionalidadDeNuevaMuestra = nuevaMuestra;
		this.funcionalidadDeValidacion = validacion;
		this.tipo = tipo;
		this.cantidadDeEmpleados = cantidadDeEmpleados;
	}


	public void funcionalidad(Muestra muestra, ZonaDeCobertura zonaDeCobertura, Funcionalidad funcionalidad) {
		if (funcionalidad == Funcionalidad.NUEVAMUESTRA) {
			this.getFuncionalidadDeNuevaMuestra().nuevoEvento(muestra, this, zonaDeCobertura);
		} else {
			this.getFuncionalidadDeValidacion().nuevoEvento(muestra, this, zonaDeCobertura);
		}
	}


	public FuncionalidadExterna getFuncionalidadDeNuevaMuestra() {
		return funcionalidadDeNuevaMuestra;
	}


	public FuncionalidadExterna getFuncionalidadDeValidacion() {
		return funcionalidadDeValidacion;
	}
}
