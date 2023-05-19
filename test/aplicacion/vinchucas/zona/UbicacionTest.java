package aplicacion.vinchucas.zona;
import java.util.*;
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

class UbicacionTest {
	private Ubicacion u1;
	private Ubicacion u2; 
	private Ubicacion u3;
	private Ubicacion u4;
	private List<Ubicacion> ubicaciones;

	@BeforeEach
	void setUp() throws Exception {
		u1 = new Ubicacion(13, 15);
		u2 = new Ubicacion(20, 12);
		u3 = new Ubicacion(1000, 1000);
		u4 = new Ubicacion(10, 10);
		Ubicacion[] ubs = {u2, u3, u4};
		ubicaciones = Arrays.asList(ubs);
	}

	@Test
	void calculoDeDistanciasEntreU1YU2() {
		assertEquals(841.4220655766954, u1.calcularDistancia(u2));
	}
	
	@Test
	void distanciasAMenosDe1000DeU1() {
		Ubicacion[] ubs = {u2, u4};
		List<Ubicacion> res = Arrays.asList(ubs);
		assertEquals(res, u1.ubicacionesAMenosDe(ubicaciones, 1000));
	}

}
