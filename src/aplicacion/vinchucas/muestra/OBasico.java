package aplicacion.vinchucas.muestra;

public class OBasico extends Verificacion {

	@Override
	public void opinar(Muestra muestra, Opinion opinion) {
		if ( opinion.esOpinionDe().esExperto()) {
			muestra.setVerificacion(new OExperto());
			}
		muestra.agregarHistorial(opinion);
		

	}

}
