package net.montaki;

import net.montaki.compression.Compresseur;
import net.montaki.compression.CompressionRLE;
import net.montaki.framework.FrameworkImage;
import net.montaki.strategy.Filtre;
import net.montaki.strategy.FiltreIdentite;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static <T> T creer(String nom, Class<T> type)
            throws ReflectiveOperationException {
        if (!nom.contains(".")) {
            nom = "net.montaki." + nom;
        }

        return Class.forName(nom)
                .asSubclass(type)
                .getDeclaredConstructor()
                .newInstance();
    }

    public static void main(String[] args) {
        int[] image = {10, 10, 10, 200, 200, 30};

        FrameworkImage framework = new FrameworkImage(
                new FiltreIdentite(),
                new CompressionRLE()
        );

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n1. Choisir le filtre");
                System.out.println("2. Choisir le compresseur");
                System.out.println("3. Executer les traitements");
                System.out.println("0. Quitter");
                System.out.print("Choix : ");

                if (!scanner.hasNextLine()) {
                    return;
                }

                String choix = scanner.nextLine().trim();

                try {
                    switch (choix) {
                        case "1":
                            System.out.println("Exemples : FiltreIdentite, "
                                    + "FiltreSeuillage, FiltreAdapter");
                            System.out.print("Classe du filtre : ");

                            if (!scanner.hasNextLine()) return;

                            framework.setFiltre(creer(
                                    scanner.nextLine().trim(),
                                    Filtre.class
                            ));

                            System.out.println("Filtre modifie.");
                            break;

                        case "2":
                            System.out.println("Exemple : CompressionRLE");
                            System.out.print("Classe du compresseur : ");

                            if (!scanner.hasNextLine()) return;

                            framework.setCompresseur(creer(
                                    scanner.nextLine().trim(),
                                    Compresseur.class
                            ));

                            System.out.println("Compresseur modifie.");
                            break;

                        case "3":
                            int[] filtree = framework.filter(image);
                            int[] compressee = framework.compresser(filtree);

                            System.out.println(
                                    "Originale  : " + Arrays.toString(image));
                            System.out.println(
                                    "Filtree    : " + Arrays.toString(filtree));
                            System.out.println(
                                    "Compressee : " + Arrays.toString(compressee));
                            break;

                        case "0":
                            return;

                        default:
                            System.out.println("Choix invalide.");
                    }
                } catch (ReflectiveOperationException | ClassCastException e) {
                    System.out.println(
                            "Classe introuvable, incompatible ou non "
                                    + "instanciable. Utilisez une classe concrete avec "
                                    + "un constructeur public sans argument.");
                } catch (RuntimeException e) {
                    System.out.println(
                            "Erreur de traitement : " + e.getMessage());
                }
            }
        }
    }
}