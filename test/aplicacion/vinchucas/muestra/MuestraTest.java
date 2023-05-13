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
	
	

}
