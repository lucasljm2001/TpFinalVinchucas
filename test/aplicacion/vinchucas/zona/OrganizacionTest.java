package aplicacion.vinchucas.zona;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import aplicacion.vinchucas.muestra.Muestra;

class OrganizacionTest {
	private Organizacion org;
	private Muestra muestra;
	private ZonaDeCobertura zona;
	private FuncionalidadExterna validacion;
	private FuncionalidadExterna nuevaMuestra;
	private Ubicacion ubicacion;

	@BeforeEach
	void setUp() throws Exception {
		ubicacion = mock(Ubicacion.class);
		muestra = mock(Muestra.class);
		zona = mock(ZonaDeCobertura.class);
		validacion = mock(FuncionalidadExterna.class);
		nuevaMuestra = mock(FuncionalidadExterna.class);
		org = new Organizacion(ubicacion, nuevaMuestra, validacion, TipoDeOrganizacion.ASISTENCIA, 5);
	} 

	@Test
	void laOrganizacionSeRegistraEnLaZona() {
		org.registrarse(zona);
		verify(zona).registrar(org);
	}
	
	@Test
	void laOrganizacionEnviaFuncionalidadesExternas() {
		org.funcionalidad(muestra, zona, Funcionalidad.NUEVAMUESTRA);
		verify(nuevaMuestra).nuevoEvento(muestra, org, zona);
		org.funcionalidad(muestra, zona, Funcionalidad.NUEVAVALIDACION);
		verify(validacion).nuevoEvento(muestra, org, zona);
	}
	
	@Test
	void laOrganizacionSeEliminaDeLosRegistros() {
		org.eliminarse(zona);
		verify(zona).sacar(org);
	}

}
