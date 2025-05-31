import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Punto> datos = new ArrayList<>();
        datos.add(new Punto(6.2442, -75.5812, 10));
        datos.add(new Punto(6.2455, -75.5780, 14));
        datos.add(new Punto(6.2470, -75.5790, 21));
        datos.add(new Punto(6.2420, -75.5825, 9));
        datos.add(new Punto(6.2410, -75.5800, 2));

        KMeans modelo = new KMeans(datos, 3);
        modelo.entrenar();
        modelo.imprimirClusters();
    }
}