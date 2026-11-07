package net.montaki.compression;

import java.util.ArrayList;
import java.util.List;

public class CompressionRLE extends Compresseur {
    @Override
    protected int[] encoder(int[] data) {
        List<Integer> resultat = new ArrayList<>();
        int compteur = 1;

        for (int i = 1; i <= data.length; i++) {
            if (i < data.length && data[i] == data[i - 1]) {
                compteur++;
            } else {
                resultat.add(data[i - 1]);
                resultat.add(compteur);
                compteur = 1;
            }
        }

        return resultat.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}