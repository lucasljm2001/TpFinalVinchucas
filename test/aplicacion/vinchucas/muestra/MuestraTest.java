package aplicacion.vinchucas.muestra;
import aplicacion.vinchucas.usuario.Basico;
import aplicacion.vinchucas.usuario.Experto;
import aplicacion.vinchucas.usuario.Usuario;

import aplicacion.vinchucas.zona.Ubicacion;

import java.time.LocalDate;
import java.util.*;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MuestraTest {

	Muestra muestra;
	Muestra muestra2;
	Usuario lucas;
	Usuario margo;
	Usuario pepin;
	Usuario nahu;
	Opinion op1;
	Opinion op2;
	Opinion op3;
	Opinion op4;
	Opinion op5;
	Ubicacion ubicacion;
	TipoDeOpinion tipoDeOpinion;
	
	@BeforeEach
	void setUp() throws Exception {
		lucas = mock(Usuario.class);
		margo = mock(Usuario.class);
		pepin = mock(Usuario.class);
		nahu = mock(Usuario.class);
		ubicacion = mock(Ubicacion.class);
				
		op1 = mock(Opinion.class);
		op2 = mock(Opinion.class);
		op3 = mock(Opinion.class);
		op4 = mock(Opinion.class);
		op5 = mock(Opinion.class);
		 
		when(op1.getUsuario()).thenReturn(margo);
		when(op2.getUsuario()).thenReturn(lucas);
		when(op3.getUsuario()).thenReturn(pepin);
		when(op4.getUsuario()).thenReturn(margo);
		when(op5.getUsuario()).thenReturn(nahu);
		
		when(op1.esOpinionDe()).thenReturn(new Experto());
		when(op2.esOpinionDe()).thenReturn(new Experto());
		when(op3.esOpinionDe()).thenReturn(new Basico());
		when(op4.esOpinionDe()).thenReturn(new Experto());
		when(op5.esOpinionDe()).thenReturn(new Basico());
		

		when(margo.getNivel()).thenReturn(new Experto());
		when(lucas.getNivel()).thenReturn(new Experto());
		when(pepin.getNivel()).thenReturn(new Basico());
		when(nahu.getNivel()).thenReturn(new Basico());
		
		
		when(op1.getTipo()).thenReturn(TipoDeOpinion.CHINCHEFOLIADA);
		when(op2.getTipo()).thenReturn(TipoDeOpinion.VINCHUCAGUASAYANA);
		when(op3.getTipo()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(op4.getTipo()).thenReturn(TipoDeOpinion.VINCHUCASORDIDA);
		when(op5.getTipo()).thenReturn(TipoDeOpinion.NINGUNA);
		
		tipoDeOpinion = TipoDeOpinion.VINCHUCASORDIDA;
		muestra = new Muestra("muestra.jpg", lucas, ubicacion, tipoDeOpinion, LocalDate.now());
		muestra2 = new Muestra("muestra2.jpg", pepin, ubicacion, tipoDeOpinion, LocalDate.now());
	}

	@Test
	void muestraNuevaNoEsVerificada() {
		assertFalse(muestra.getVerificacion().esVerificada());
	}
	
	@Test
	void usuarioBasicoNoPuedeOpinarLuegoDelExperto() {
		muestra.getVerificacion().opinar(muestra,op3);
		assertEquals(1,muestra.getHistorial().size());
	}

	@Test
	void dosExpertosOpinanIgualYNadieMasPuedeVotar() { 
		muestra.getVerificacion().opinar(muestra,op4);
		assertTrue(muestra.getVerificacion().esVerificada());
		muestra.actualizarResultado();
		assertEquals(TipoDeOpinion.VINCHUCASORDIDA, muestra.getResultadoActual());
		muestra.getVerificacion().opinar(muestra,op3);
		assertEquals(2,muestra.getHistorial().size());
	}
	
	@Test
	void dosExpertosNoOpinanIgual() { 
		muestra.getVerificacion().opinar(muestra,op1);
		assertEquals(TipoDeOpinion.NODEFINIDO, muestra.getResultadoActual());
	}
	
	@Test
	void nadiePuedeVotarDosVecesSobreLaMismaMuestra() {
		muestra.getVerificacion().opinar(muestra,op2);
		assertEquals(1,muestra.getHistorial().size());
	}
	
	@Test
	void dosUsuariosBasicoOpinan() {
		muestra2.getVerificacion().opinar(muestra2,op5);
		assertEquals(2,muestra2.getHistorial().size());
	}
		
	@Test
	void dosUsuariosBasicoOpinanYLuegoOpinaUnExpertoLuego() {
		muestra2.getVerificacion().opinar(muestra2,op5);
		assertEquals(2,muestra2.getHistorial().size());
		muestra2.getVerificacion().opinar(muestra2, op1);
		assertEquals(TipoDeOpinion.CHINCHEFOLIADA, muestra2.getResultadoActual());
	}
}
