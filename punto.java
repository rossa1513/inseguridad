class Punto {
    double lat, lon, hora;
    int cluster;

    Punto(double lat, double lon, double hora) {
        this.lat = lat;
        this.lon = lon;
        this.hora = hora;
        this.cluster = -1;
    }

    double distancia(Punto otro) {
        return Math.sqrt(Math.pow(lat - otro.lat, 2) +
                         Math.pow(lon - otro.lon, 2) +
                         Math.pow(hora - otro.hora, 2));
    }
}

