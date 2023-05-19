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
	private List<Organizacion> organizaciones;
	
	
	public ZonaDeCobertura(double radio, String nombre, Ubicacion epicentro) {
		this.radio = radio;
		this.nombre = nombre;
		this.epicentro = epicentro;
		organizaciones = new ArrayList<Organizacion>();
	}

	public double getRadio() {
		return radio;  
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public boolean esZonaSolapada(ZonaDeCobertura zona) {
		return this.epicentro.calcularDistancia(zona.getEpicentro()) < this.radio + zona.getRadio();
	}
	
	public boolean ubicacionEstaEnElRango(Ubicacion ubicacion) {
		return ubicacion.calcularDistancia(epicentro) <= radio;
	}
	
	public void notificar(Muestra muestra, Funcionalidad funcionalidad) {
		organizaciones.stream().forEach(o->o.funcionalidad(muestra, this, funcionalidad));
	}

	public void registrar(Organizacion organizacion) {
		organizaciones.add(organizacion);	
	}
	
	public void sacar(Organizacion organizacion) {
		organizaciones.remove(organizacion);
	}
	
	
}
