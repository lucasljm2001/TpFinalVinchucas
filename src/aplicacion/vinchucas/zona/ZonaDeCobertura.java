package aplicacion.vinchucas.zona;

import java.util.ArrayList;
import java.util.List;

import org.mockito.internal.matchers.Or;

import aplicacion.sistema.SistemaDeVinchuca;
import aplicacion.vinchucas.muestra.Muestra;

public class ZonaDeCobertura{
	private double radio;
	private String nombre;
	private Ubicacion epicentro;
	private List<Observer> organizaciones;
	
	
	public ZonaDeCobertura(double radio, String nombre, Ubicacion epicentro) {
		this.radio = radio;
		this.nombre = nombre;
		this.epicentro = epicentro;
		organizaciones = new ArrayList<Observer>();
	}

	public double getRadio() {
		return radio;  
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public boolean esZonaSolapada(ZonaDeCobertura zona) {
		return this.getEpicentro().calcularDistancia(zona.getEpicentro()) < this.getRadio() + zona.getRadio();
	}
	
	public boolean ubicacionEstaEnElRango(Ubicacion ubicacion) {
		return ubicacion.calcularDistancia(this.getEpicentro()) <= this.getRadio();
	}
	
	public void notificar(Muestra muestra, Funcionalidad funcionalidad) {
		this.getOrganizaciones().stream().forEach(o->o.funcionalidad(muestra, this, funcionalidad));
	}

	public void registrar(Organizacion organizacion) {
		this.getOrganizaciones().add(organizacion);	
	}
	
	public void sacar(Organizacion organizacion) {
		this.getOrganizaciones().remove(organizacion);
	}

	public List<Observer> getOrganizaciones() {
		return organizaciones;
	}
	
	
}
