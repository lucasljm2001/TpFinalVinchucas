package aplicacion.vinchucas.muestra;

public class OExperto extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion) {
		if (opinion.esOpinionDe().esExperto()) {
			muestra.agregarHistorial(opinion);
		} 
		if (muestra.dosExpertosOpinaronIgual(opinion)) {
			muestra.setVerificacion(new Verificada());
		}

	}
	

}
