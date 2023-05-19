package aplicacion.sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.Ubicacion;
import aplicacion.vinchucas.zona.ZonaDeCobertura;

class SistemaTest {
	SistemaDeVinchuca sistema;
	ZonaDeCobertura bernal;
	ZonaDeCobertura berazategui;
	ZonaDeCobertura varela;
	
	Usuario lucas;
	Usuario margo;
	Usuario martin;
	Usuario nahu;
	Usuario pepin;
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	Muestra muestra5;
	Muestra muestra6;
	
	Ubicacion ubi1;
	Ubicacion ubi2;
	Ubicacion ubi3;
	Ubicacion ubi4;


	@BeforeEach
	void setUp() {
		lucas = mock(Usuario.class);
		margo = mock(Usuario.class);
		martin = mock(Usuario.class);
		nahu = mock(Usuario.class);
		pepin = mock(Usuario.class);
		
		Usuario[] usu = {lucas,margo,martin,nahu,pepin};
		List<Usuario> usuarios = Arrays.asList(usu);
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestra5 = mock(Muestra.class);
		muestra6 = mock(Muestra.class);
		
		Muestra[] mues = {muestra1,muestra2,muestra3,muestra4,muestra5};
		List<Muestra> muestras = Arrays.asList(mues);
		
		bernal = mock(ZonaDeCobertura.class);
		berazategui = mock(ZonaDeCobertura.class);
		varela = mock(ZonaDeCobertura.class);
		
		ZonaDeCobertura[] zon = {bernal, berazategui, varela};
		List<ZonaDeCobertura> zonas = Arrays.asList(zon);

		sistema = new SistemaDeVinchuca(zonas, usuarios, muestras);
		
		ubi1 = new Ubicacion(13, 15);
		ubi2 = new Ubicacion(20, 12);
		ubi3 = new Ubicacion(1000, 1000);
		ubi4 = new Ubicacion(10, 10);

		when(bernal.getEpicentro()).thenReturn(ubi1);
		when(berazategui.getEpicentro()).thenReturn(ubi2);
		when(varela.getEpicentro()).thenReturn(ubi3);
		when(bernal.getRadio()).thenReturn(400d);
		when(varela.getRadio()).thenReturn(200d);
		when(berazategui.getRadio()).thenReturn(500d);
		when(muestra1.getUbicacion()).thenReturn(ubi1);
		when(muestra2.getUbicacion()).thenReturn(ubi1);
		when(muestra3.getUbicacion()).thenReturn(ubi2);
		when(muestra4.getUbicacion()).thenReturn(ubi3);
		when(muestra5.getUbicacion()).thenReturn(ubi4);
		
	}
	
	@Test
	void agregaNuevaMuestraAlSistema() {
		SistemaDeVinchuca sistema2 = new SistemaDeVinchuca();
		sistema2.agregarMuestra(muestra6);
		assertEquals(1,sistema2.getMuestras().size());
	}
	
	@Test
	void todasLasMuestrasAMenosDe() {
		// terminar
	}

}
