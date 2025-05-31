import java.io.*;

public class YOLOv5Integration {
    public static void main(String[] args) {
        try {
            ProcessBuilder pb = new ProcessBuilder("python", "deteccion.py");
            pb.redirectErrorStream(true);
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println("YOLO: " + linea);
                if (linea.contains("ALERTA")) {
                    System.out.println(">>> ALERTA DETECTADA: Activar protocolo.");
                }
            }

            int exitCode = process.waitFor();
            System.out.println("Python finalizó con código: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}