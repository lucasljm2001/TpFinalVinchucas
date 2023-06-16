package aplicacion.vinchucas.muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import aplicacion.sistema.SistemaDeVinchuca;
import aplicacion.vinchucas.usuario.*;
import aplicacion.vinchucas.zona.Ubicacion;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.time.LocalDate;
import java.util.*;

class UsuarioTest {

	// SUT -> Usuario
	Usuario lucas;
	Usuario margo;
	Usuario martin;
	List<Usuario> usuarios;
	Opinion opinion;
	SistemaDeVinchuca sistema;
	Usuario pepe;

	
	@BeforeEach
	void setUp() {
		margo = new Usuario("100");
		lucas = new Usuario("200");
		martin = new Usuario("300");  
		pepe = spy(Usuario.class);
		pepe.setNivel(new Experto()); 
		lucas.esExterno();
		sistema = mock(SistemaDeVinchuca.class);
	
		
		opinion = mock(Opinion.class);
		}
			
	@Test
	void actualizacionDeNivel() {
		// un usario sube y baja de nivel por las opiniones y envios al sistema. 
		Ubicacion ubicacion = mock(Ubicacion.class);
		
		for(int i=0; i< 22; i++) {
			martin.sumarRevision();
		}
		for(int i=22; i < 33 ;i++ ) {
			martin.enviar(new Muestra("Vinchuca.jpg", martin, ubicacion, TipoDeOpinion.VINCHUCAGUASAYANA), sistema);
		}

		assertTrue(martin.getNivel().esExperto());
		martin.setFechasEnvios(new ArrayList<LocalDate>()); 
		martin.actualizarNivel();
		assertFalse(martin.getNivel().esExperto());
	}
	
	@Test
	void elExpertoExternoNoCambia() {
		lucas.setFechasEnvios(new ArrayList<LocalDate>());
		lucas.actualizarNivel();
		assertTrue(lucas.getNivel().esExperto());
	} 
	
	@Test 
	void sumarRevisionAlUsuario() {
		pepe.actualizarNivel();
		assertFalse(pepe.getNivel().esExperto());
	}
	
	@Test
	void losUsuariosTienenIdDiferentes() {
		assertFalse(lucas.getId().equals(margo.getId()));
	}
	
	@Test
	void seSumaUnaRevisionAlUsuario() {
		pepe.sumarRevision();
		assertEquals(1, pepe.getFechasRevisiones().size());
	}
}
