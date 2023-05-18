package aplicacion.vinchucas.zona;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aplicacion.vinchucas.muestra.Muestra;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

class ZonaTest {
	
	private ZonaDeCobertura berazategui;
	private ZonaDeCobertura bernal;
	private ZonaDeCobertura varela;
	private Ubicacion centroBernal;
	private Ubicacion centroVarela;
	private Ubicacion centroBerazategui;
	private Organizacion org1;
	private Organizacion org2;
	private Muestra muestra;
	
	

	@BeforeEach
	void setUp() throws Exception {
		centroBernal = mock(Ubicacion.class);
		centroVarela = mock(Ubicacion.class);
		centroBerazategui = mock(Ubicacion.class);
		org1 = mock(Organizacion.class);
		org2 = mock(Organizacion.class);
		berazategui = new ZonaDeCobertura(100, "bera", centroBerazategui);
		bernal = new ZonaDeCobertura(25, "bernal", centroBernal);
		varela = new ZonaDeCobertura(500, "bera", centroVarela);
		when(centroBerazategui.calcularDistancia(centroBernal)).thenReturn(300d);
		when(centroVarela.calcularDistancia(centroBernal)).thenReturn(1000d);
		when(centroBerazategui.calcularDistancia(centroVarela)).thenReturn(200d);
		varela.registrar(org1);
		muestra = mock(Muestra.class);
	}

	@Test
	void varelaSeSolapaConBeraYNoConBernal() {
		assertTrue(varela.esZonaSolapada(berazategui));
		assertFalse(varela.esZonaSolapada(bernal));
	}
	
	@Test
	void seEnvianValidacionesYNuevasMuestrasAVarela() {
		varela.notificarOrganizacionesDeNuevaMuestra(muestra);
		verify(org1).funcionalidadNuevaMuestra(muestra, varela);
		varela.notificarOrganizacionesDeValidacion(muestra);
		verify(org1).funcionalidadNuevaMuestra(muestra, varela);
		varela.sacar(org1);
		varela.registrar(org2);
		varela.notificarOrganizacionesDeValidacion(muestra);
		verify(org2).funcionalidadValidacion(muestra, varela);
	}
	
	@Test
	void elEpicentroEstaEnLaZona() {
		assertTrue(varela.ubicacionEstaEnElRango(centroVarela));
	}

}
