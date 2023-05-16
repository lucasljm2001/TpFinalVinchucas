package aplicacion.vinchucas.muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
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

import java.util.*;

class UsuarioTest {

	// SUT -> Usuario
	Usuario lucas;
	Usuario margo;
	Usuario martin;
	List<Muestra> muestras;
	List<Usuario> usuarios;
	Opinion opinion;
	SistemaDeVinchuca sistema;
	
	@BeforeEach
	void setUp() {
		margo = new Usuario("100");
		lucas = new Usuario("200");
		martin = new Usuario("300");
		lucas.esExperto();
		muestras = new ArrayList<Muestra>();
				
		for (int i=0; i < 40; i++) {
			muestras.add(mock(Muestra.class));		
			when(muestras.get(i).getVerificacion()).thenReturn(mock(OBasico.class));
		}
		opinion = mock(Opinion.class);
		

		
	}
	
//	@Test
//	void bajaDeNivel() { PREGUNTAR COMO HACER PARA QUE PASEN 30 DIAS Y NO ESPERAR 30 DIAS AL LADO DE MI PC 
//		
//	}
	
	@Test
	void actualizacionDeNivel() {
		Ubicacion ubicacion = mock(Ubicacion.class);
		
		for(int i=0; i< 21; i++) {
			martin.opinar(muestras.get(i), TipoDeOpinion.IMAGENPOCOCLARA);	
		}
		for(int i=22; i < 33 ;i++ ) {
			martin.enviar("Vinchuca.jpg", ubicacion, TipoDeOpinion.VINCHUCAGUASAYANA);
		}
		assertTrue(martin.getNivel().esExperto());
		
	}
	
	@Test
	void elExpertoExternoNoCambia() {
		lucas.opinar(muestras.get(1), TipoDeOpinion.IMAGENPOCOCLARA);;
		assertTrue(lucas.getNivel().esExperto());
	}
	
}
