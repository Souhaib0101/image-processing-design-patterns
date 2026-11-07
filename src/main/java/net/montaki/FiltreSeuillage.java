package net.montaki;

public class FiltreSeuillage implements Filtre {
    @Override
    public int[] filter(int[] data) {
        int[] resultat = new int[data.length];

        for (int i = 0; i < data.length; i++) {
            resultat[i] = data[i] >= 128 ? 255 : 0;
        }

        return resultat;
    }
}