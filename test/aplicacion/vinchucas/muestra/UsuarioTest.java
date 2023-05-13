package aplicacion.vinchucas.muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import aplicacion.vinchucas.usuario.*;
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
		//deberiamos hacer que cada usuario opine una sola vez por cada muestra.
		//y que no pueda opinar sobre una muestra que el mismo haya enviado.

		
	}
	
	
	@Test
	void usuarioBasicoNoPuedeOpinarLuegoDelExperto() {
		lucas.opinar(muestras.get(0), TipoDeOpinion.NINGUNA);
		verifyNoMoreInteractions(muestras.get(0));
		margo.opinar(muestras.get(0), TipoDeOpinion.CHINCHEFOLIADA);
		
	}

	@Test
	void dosExpertosOpinanIgual() { 
		margo.esExperto();
		lucas.opinar(muestras.get(2), TipoDeOpinion.VINCHUCAGUASAYANA);
		margo.opinar(muestras.get(2), TipoDeOpinion.VINCHUCAGUASAYANA);
		verifyNoMoreInteractions(muestras.get(2));
		martin.opinar(muestras.get(2), TipoDeOpinion.IMAGENPOCOCLARA);
		
	}
}
