package net.montaki.legacy;

public class ImplNonStandard {
    public int[] appliquerFiltre(String filterName, int[] data) {
        if (!"negatif".equals(filterName)) {
            throw new IllegalArgumentException(
                    "Filtre inconnu : " + filterName);
        }

        int[] resultat = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            resultat[i] = 255 - data[i];
        }

        return resultat;
    }
}