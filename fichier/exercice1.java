package fichier;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class exercice1 {
    public static void main(String[] args) {
        String fichierSource = "fichier1.txt";
        String fichierDestination = "fichier2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(fichierSource));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fichierDestination, true))) {

            // Copie du fichier
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                writer.write(ligne);
                writer.newLine();
            }

            // Calcul des statistiques
            int nbCaracteres = 0;
            int nbMots = 0;
            int nbLignes = 0;

            try (BufferedReader statReader = new BufferedReader(new FileReader(fichierSource))) {
                String contenu;
                while ((contenu = statReader.readLine()) != null) {
                    nbCaracteres += contenu.length();
                    nbMots += contenu.split("\\s+").length;
                    nbLignes++;
                }
            }

            // Ajout des statistiques dans fichier.txt
            writer.write("\n\nNombre de caractères lus : " + nbCaracteres);
            writer.newLine();
            writer.write("Nombre de mots : " + nbMots);
            writer.newLine();
            writer.write("Nombre de lignes : " + nbLignes);

            System.out.println("Opération réussie. Vérifiez fichier2.txt.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
