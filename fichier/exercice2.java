package fichier;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class exercice2 {
    public static void main(String[] args) {
        // Chemins des fichiers source et destination
        String inputFile = "fichier1.txt";
        String outputFile = "fichier2.txt";

        try (FileInputStream inputStream = new FileInputStream(inputFile);
             FileOutputStream outputStream = new FileOutputStream(outputFile, true)) {

            // Copie du contenu de fichier1.txt vers fichier2.txt
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            // Calcul du nombre de caractères, mots et lignes
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            try (FileInputStream statInputStream = new FileInputStream(inputFile)) {
                byte[] content = new byte[1024];
                int bytesReadStat;
                while ((bytesReadStat = statInputStream.read(content)) != -1) {
                    String contentStr = new String(content, 0, bytesReadStat);
                    charCount += contentStr.length();
                    wordCount += contentStr.split("\\s+").length;
                    lineCount += contentStr.split("\n").length;
                }
            }

            // Ajout des statistiques à fichier2.txt
            String stats = "Nombre de caractères: " + charCount + "\n"
                         + "Nombre de mots: " + wordCount + "\n"
                         + "Nombre de lignes: " + lineCount + "\n";

            outputStream.write(stats.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
