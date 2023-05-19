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
		when(usuario.getNivel()).thenReturn(new Experto());
		when(experto.getNivel()).thenReturn(new Experto());
		ubicacion = mock(Ubicacion.class);
		filtroTipo = new FiltroTipoDeInsecto(TipoDeOpinion.PHTIACHINCHE);
		filtroVerificacion = new FiltroNivelVerificacion(new Verificada());
		filtroCreacion = new FiltroFechaDeCreacion(LocalDate.now());
		criterioIgual = new FechaIgual();
		criterioPosterior = new FechaPosterior();
		criterioAnterior = new FechaAnterior();
		filtroModificacionIgual = new FiltroFechaDeUltimaModificacion(criterioIgual, LocalDate.of(2023, 20, 5));
		filtroModificacionAnterior = new FiltroFechaDeUltimaModificacion(criterioAnterior, LocalDate.of(2023, 3, 4));
		filtroModificacionPosterior = new FiltroFechaDeUltimaModificacion(criterioPosterior, LocalDate.of(2023, 10, 5));
		filtroAnd = new FiltroAnd();
		filtroOr = new FiltroOr();
		
		muestra1 = new Muestra("img.jpg", usuario, ubicacion, TipoDeOpinion.PHTIACHINCHE, LocalDate.now());
		muestra2 = new Muestra("img.jpg", usuario, ubicacion, TipoDeOpinion.PHTIACHINCHE, LocalDate.of(2023, 20, 5));
		muestra3 = new Muestra("img.jpg", usuario, ubicacion, TipoDeOpinion.NINGUNA, LocalDate.of(2023, 2, 5));
		muestra4 = new Muestra("img.jpg", usuario, ubicacion, TipoDeOpinion.IMAGENPOCOCLARA, LocalDate.of(2023, 15, 5));
		
		filtroAnd.agregarFiltro(filtroTipo);
		filtroOr.agregarFiltro(filtroVerificacion);
		filtroOr.agregarFiltro(filtroModificacionIgual);
		filtroAnd.agregarFiltro(filtroAnd);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
