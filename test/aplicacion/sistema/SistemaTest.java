package aplicacion.sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.TipoDeOpinion;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.Funcionalidad;
import aplicacion.vinchucas.zona.Ubicacion;
import aplicacion.vinchucas.zona.ZonaDeCobertura;

class SistemaTest {
	SistemaDeVinchuca sistema;
	ZonaDeCobertura bernal;
	ZonaDeCobertura berazategui;
	ZonaDeCobertura varela;
	ZonaDeCobertura zonaMock;
	
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
	
	Usuario usuario;


	@BeforeEach
	void setUp() {	
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		muestra5 = mock(Muestra.class);
		muestra6 = mock(Muestra.class);
		usuario = mock(Usuario.class);
		zonaMock = mock(ZonaDeCobertura.class);
		
		Muestra[] mues = {muestra1,muestra2,muestra3,muestra4,muestra5};
		List<Muestra> muestras = Arrays.asList(mues);
		
		ubi1 = new Ubicacion(13, 15);
		ubi2 = new Ubicacion(20, 12);
		ubi3 = new Ubicacion(1000, 1000);
		ubi4 = new Ubicacion(10, 10);

		bernal = new ZonaDeCobertura(500, "Bernal", ubi1);
		berazategui = new ZonaDeCobertura(500, "Berazategui", ubi2);
		varela = new ZonaDeCobertura(200, "Varela", ubi3);
		when(zonaMock.ubicacionEstaEnElRango(ubi1)).thenReturn(true);
		
		ZonaDeCobertura[] zon = {bernal, berazategui, varela, zonaMock};
		List<ZonaDeCobertura> zonas = Arrays.asList(zon);
				
		
		when(muestra1.getUbicacion()).thenReturn(ubi1);
		when(muestra2.getUbicacion()).thenReturn(ubi1);
		when(muestra3.getUbicacion()).thenReturn(ubi2);
		when(muestra4.getUbicacion()).thenReturn(ubi3);
		when(muestra5.getUbicacion()).thenReturn(ubi4);
		sistema = new SistemaDeVinchuca(zonas,  muestras);
	}
	
	@Test
	void agregaNuevaMuestraAlSistema() {
		SistemaDeVinchuca sistema2 = new SistemaDeVinchuca();
		sistema2.agregarMuestra(muestra6); 
		assertEquals(1,sistema2.getMuestras().size());
	}
	 
	@Test
	void todasLasMuestrasAMenosDe() { 
		Muestra[] muestrasArray = {muestra2,muestra3,muestra5 };
		List<Muestra> muestras = Arrays.asList(muestrasArray);
		assertEquals(muestras,sistema.todasLasMuestrasAMenosDe(muestra1, 1000));
	}
	
	@Test
	void zonasSolapadasBernalYBerazategui() {
		ZonaDeCobertura[] zonasArray = {berazategui};
		List<ZonaDeCobertura> zonass = Arrays.asList(zonasArray);
		assertEquals(zonass, sistema.zonasSolapadas(bernal) );
	}

	@Test 
	void muestrasDeLaZona() {
		Muestra[] muestrasArray = {muestra1,muestra2 };
		List<Muestra> muestras = Arrays.asList(muestrasArray); 
		assertEquals(muestras, sistema.muestrasDeZona(bernal));	
	}
	
	@Test
	void elSistemaHaceEnviarAlUsuario() {
		sistema.usuarioEnviarMuestra(usuario, "foto.jpg", ubi1, TipoDeOpinion.NINGUNA);
		verify(usuario).enviar("foto.jpg", ubi1, TipoDeOpinion.NINGUNA, sistema);
	}
	
	@Test
	void seValidaUnaNuevaMuestra() {
		sistema.notificarCambioALasZonas(muestra1, Funcionalidad.NUEVAVALIDACION);
		verify(zonaMock).notificar(muestra1, Funcionalidad.NUEVAVALIDACION);
	}
	
	
	
}
