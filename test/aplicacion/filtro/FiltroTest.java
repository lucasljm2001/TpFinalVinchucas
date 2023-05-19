package aplicacion.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import aplicacion.filtro.criteriosCompuestos.FiltroAnd;
import aplicacion.filtro.criteriosCompuestos.FiltroOr;
import aplicacion.filtro.criteriosSimples.CriterioFecha;
import aplicacion.filtro.criteriosSimples.FiltroFechaDeCreacion;
import aplicacion.filtro.criteriosSimples.FiltroFechaDeUltimaModificacion;
import aplicacion.filtro.criteriosSimples.FiltroNivelVerificacion;
import aplicacion.filtro.criteriosSimples.FiltroTipoDeInsecto;
import aplicacion.filtro.criteriosSimples.fechas.FechaAnterior;
import aplicacion.filtro.criteriosSimples.fechas.FechaIgual;
import aplicacion.filtro.criteriosSimples.fechas.FechaPosterior;
import aplicacion.vinchucas.muestra.Muestra;
import aplicacion.vinchucas.muestra.OBasico;
import aplicacion.vinchucas.muestra.OExperto;
import aplicacion.vinchucas.muestra.TipoDeOpinion;
import aplicacion.vinchucas.muestra.Verificada;
import aplicacion.vinchucas.usuario.Experto;
import aplicacion.vinchucas.usuario.Usuario;
import aplicacion.vinchucas.zona.Ubicacion;

class FiltroTest {
	CriterioCompuesto filtroAnd;
	CriterioCompuesto filtroOr;
	Filtro filtroCreacion;
	Filtro filtroModificacionIgual;
	Filtro filtroModificacionPosterior;
	Filtro filtroModificacionAnterior;
	Filtro filtroVerificacion;
	Filtro filtroTipo;
	Filtro filtroTipoNuevo;
	
	CriterioFecha criterioIgual;
	CriterioFecha criterioPosterior;
	CriterioFecha criterioAnterior;
	
	List<Muestra> muestras;
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	
	Usuario usuario;
	Usuario experto;
	Ubicacion ubicacion;
	

	@BeforeEach
	void setUp() throws Exception {
		usuario = mock(Usuario.class);
		experto = mock(Usuario.class);
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);

		when(muestra1.ultimaModificacion()).thenReturn(LocalDate.now());
		when(muestra2.ultimaModificacion()).thenReturn(LocalDate.now());
		when(muestra3.ultimaModificacion()).thenReturn(LocalDate.of(2023, 4, 29));
		when(muestra4.ultimaModificacion()).thenReturn(LocalDate.of(2023, 5, 9));
		
		when(muestra1.getResultadoActual()).thenReturn(TipoDeOpinion.NINGUNA);
		when(muestra2.getResultadoActual()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		when(muestra3.getResultadoActual()).thenReturn(TipoDeOpinion.VINCHUCAGUASAYANA);
		when(muestra4.getResultadoActual()).thenReturn(TipoDeOpinion.PHTIACHINCHE);
		
		when(muestra1.getVerificacion()).thenReturn(new Verificada());
		when(muestra2.getVerificacion()).thenReturn(new Verificada());
		when(muestra3.getVerificacion()).thenReturn(new Verificada());
		when(muestra4.getVerificacion()).thenReturn(new OExperto());
		
		when(muestra1.getFecha()).thenReturn(LocalDate.now());
		when(muestra2.getFecha()).thenReturn(LocalDate.now());
		when(muestra3.getFecha()).thenReturn(LocalDate.of(2023, 4, 29));
		when(muestra4.getFecha()).thenReturn(LocalDate.of(2023, 5, 9));
		
		ubicacion = mock(Ubicacion.class);
		
		when(usuario.getNivel()).thenReturn(new Experto());
		when(experto.getNivel()).thenReturn(new Experto());
		
		filtroTipoNuevo = new FiltroTipoDeInsecto(TipoDeOpinion.VINCHUCAINFESTANS);
		filtroTipo = new FiltroTipoDeInsecto(TipoDeOpinion.PHTIACHINCHE);
		filtroVerificacion = new FiltroNivelVerificacion(new Verificada());
		filtroCreacion = new FiltroFechaDeCreacion(LocalDate.now());
		criterioIgual = new FechaIgual();
		criterioPosterior = new FechaPosterior();
		criterioAnterior = new FechaAnterior();
		filtroModificacionIgual = new FiltroFechaDeUltimaModificacion(criterioIgual, LocalDate.now());
		filtroModificacionAnterior = new FiltroFechaDeUltimaModificacion(criterioAnterior, LocalDate.of(2023, 5, 10));
		filtroModificacionPosterior = new FiltroFechaDeUltimaModificacion(criterioPosterior, LocalDate.of(2023, 5, 2));
		filtroAnd = new FiltroAnd();
		filtroOr = new FiltroOr();
		
		filtroAnd.agregarFiltro(filtroTipo);
		filtroOr.agregarFiltro(filtroVerificacion);
		filtroOr.agregarFiltro(filtroModificacionIgual);
		filtroAnd.agregarFiltro(filtroOr);
		
		muestras = new ArrayList<Muestra>();
		
		muestras.add(muestra1);
		muestras.add(muestra2);
		muestras.add(muestra3);
		muestras.add(muestra4);
	}

	@Test
	void muestrasModificadasIgualesALaFecha() {
		Muestra[] muestrario = {muestra1, muestra2};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroModificacionIgual.filtrar(muestras));
	}
	
	@Test
	void muestrasFiltroCreacion() {
		Muestra[] muestrario = {muestra1, muestra2};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroCreacion.filtrar(muestras));
	}

	@Test
	void muestrasModificadasPosterioresALaFecha() {
		Muestra[] muestrario = {muestra1, muestra2,muestra4};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroModificacionPosterior.filtrar(muestras));
	}

	@Test
	void muestrasModificadasAnterioresALaFecha() {
		Muestra[] muestrario = {muestra3,muestra4};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroModificacionAnterior.filtrar(muestras));
	}
	
	@Test
	void filtroAndOr() {
		Muestra[] muestrario = {muestra2};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroAnd.filtrar(muestras));
	}
	
	@Test
	void filtroOr() {
		Muestra[] muestrario = {muestra1, muestra2, muestra3};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroOr.filtrar(muestras));
	}

	@Test
	void filtroOrTriple() {
		filtroOr.agregarFiltro(filtroModificacionAnterior);
		Muestra[] muestrario = {muestra1, muestra2, muestra3, muestra4};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroOr.filtrar(muestras));
	}

	@Test
	void filtroAndTriple() {
		CriterioCompuesto filtroAnd2 = new FiltroAnd();
		filtroAnd2.agregarFiltro(filtroModificacionAnterior);
		filtroAnd2.agregarFiltro(filtroTipoNuevo);
		filtroAnd2.agregarFiltro(filtroCreacion);
		Muestra[] muestrario = {};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroAnd2.filtrar(muestras));
	}

	@Test
	void eliminoUnFiltro() {
		filtroOr.eliminarFiltro(filtroVerificacion);
		Muestra[] muestrario = {muestra2};
		List<Muestra> resultado = Arrays.asList(muestrario);
		assertEquals(resultado, filtroAnd.filtrar(muestras));
	}

}
