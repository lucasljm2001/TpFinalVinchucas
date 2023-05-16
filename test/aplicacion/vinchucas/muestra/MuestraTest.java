package aplicacion.vinchucas.muestra;
import aplicacion.vinchucas.usuario.Basico;
import aplicacion.vinchucas.usuario.Usuario;

import aplicacion.vinchucas.zona.Ubicacion;

import java.time.LocalDate;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {

	Muestra muestra1;
	Usuario usuario;
	Ubicacion ubicacion;
	TipoDeOpinion tipoDeOpinion;
	
	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		ubicacion = mock(Ubicacion.class);
		when(usuario.getNivel()).thenReturn(new Basico(usuario));
		
		tipoDeOpinion = TipoDeOpinion.VINCHUCASORDIDA;
		muestra1 = new Muestra("sordida.jpg", usuario, ubicacion, tipoDeOpinion, LocalDate.now());
	}

	@Test
	void muestraNuevaNoEsVerificada() {
		assertFalse(muestra1.getVerificacion().esVerificada());
	}
//	
//	@Test
//	void usuarioBasicoNoPuedeOpinarLuegoDelExperto() {
//		lucas.opinar(muestras.get(0), TipoDeOpinion.NINGUNA);
//		verify(muestras.get(0),never()).opino(margo);
//		margo.opinar(muestras.get(0), TipoDeOpinion.CHINCHEFOLIADA);
//		
//	}
//
//	@Test
//	void dosExpertosOpinanIgual() { 
//		margo.esExperto();
//		lucas.opinar(muestras.get(2), TipoDeOpinion.VINCHUCAGUASAYANA);
//		margo.opinar(muestras.get(2), TipoDeOpinion.VINCHUCAGUASAYANA);
//		verify(muestras.get(2), never()).opino(martin);
//		martin.opinar(muestras.get(2), TipoDeOpinion.IMAGENPOCOCLARA);
//		
//	}
//	

}
