package aplicacion.vinchucas.zona;

import java.lang.Math;
import java.util.List;

public class Ubicacion {
    private double latitud;
    private double longitud;

    public Ubicacion(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public double calcularDistancia(Ubicacion otraUbicacion) {
        double radioTierra = 6371; // Radio promedio de la Tierra en kilómetros

        double latitud1 = Math.toRadians(this.latitud);
        double longitud1 = Math.toRadians(this.longitud);
        double latitud2 = Math.toRadians(otraUbicacion.getLatitud());
        double longitud2 = Math.toRadians(otraUbicacion.getLongitud());

        double diferenciaLatitud = latitud2 - latitud1;
        double diferenciaLongitud = longitud2 - longitud1;

        double a = Math.sin(diferenciaLatitud / 2) * Math.sin(diferenciaLatitud / 2)
                + Math.cos(latitud1) * Math.cos(latitud2) * Math.sin(diferenciaLongitud / 2) * Math.sin(diferenciaLongitud / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distancia = radioTierra * c;
 
        return distancia;
    }
    
    public List<Ubicacion> ubicacionesAMenosDe(List<Ubicacion> ubicaciones, double distancia){
    	return ubicaciones.stream().filter(u -> this.calcularDistancia(u) < distancia).toList();
    }


}