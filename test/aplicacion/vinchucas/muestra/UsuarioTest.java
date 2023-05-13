package aplicacion.vinchucas.muestra;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;

import aplicacion.vinchucas.usuario.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;

class UsuarioTest {

	// SUT -> Usuario
	Usuario lucas;
	Usuario margo;
	List<Muestra> muestras;
	List<Usuario> usuarios;
	Opinion opinion;
	
	@BeforeEach
	void setUp() {
		margo = new Usuario("100");
		lucas = new Usuario("200");
		lucas.esExperto();
		muestras = new ArrayList<Muestra>();
		for (int i=0; i < 40; i++) {
			//usuarios.add(new Usuario("00" + i ));
			muestras.add(mock(Muestra.class));		
		}
		opinion = mock(Opinion.class);
		
		
	}
	
	
	@Test
	void usuarioBasicoNoPuedeOpinarLuegoDelExperto() {
		lucas.opinar(muestras.get(0), TipoDeOpinion.NINGUNA);
		margo.opinar(muestras.get(0), TipoDeOpinion.CHINCHEFOLIADA);
		verifyNoMoreInteractions(muestras.get(0));
		
	}


}
