import java.util.*;
public class KMeans {
    private List<Punto> puntos;
    private Punto[] centroides;
    private int k;

    public KMeans(List<Punto> puntos, int k) {
        this.puntos = puntos;
        this.k = k;
        this.centroides = new Punto[k];
    }

    public void entrenar() {
        Random rand = new Random();
        for (int i = 0; i < k; i++) {
            Punto p = puntos.get(rand.nextInt(puntos.size()));
            centroides[i] = new Punto(p.lat, p.lon, p.hora);
        }

        boolean cambio;
        do {
            cambio = false;
            for (Punto p : puntos) {
                int clusterCercano = -1;
                double minDistancia = Double.MAX_VALUE;
                for (int i = 0; i < k; i++) {
                    double d = p.distancia(centroides[i]);
                    if (d < minDistancia) {
                        minDistancia = d;
                        clusterCercano = i;
                    }
                }
                if (p.cluster != clusterCercano) {
                    p.cluster = clusterCercano;
                    cambio = true;
                }
            }

            for (int i = 0; i < k; i++) {
                double sumaLat = 0, sumaLon = 0, sumaHora = 0;
                int total = 0;
                for (Punto p : puntos) {
                    if (p.cluster == i) {
                        sumaLat += p.lat;
                        sumaLon += p.lon;
                        sumaHora += p.hora;
                        total++;
                    }
                }
                if (total > 0) {
                    centroides[i] = new Punto(sumaLat / total, sumaLon / total, sumaHora / total);
                }
            }

        } while (cambio);
    }

    public void imprimirClusters() {
        for (int i = 0; i < k; i++) {
            System.out.println("Cluster " + i + ":");
            for (Punto p : puntos) {
                if (p.cluster == i) {
                    System.out.printf("  Lat: %.4f, Lon: %.4f, Hora: %.2f\n", p.lat, p.lon, p.hora);
                }
            }
        }
    }
}