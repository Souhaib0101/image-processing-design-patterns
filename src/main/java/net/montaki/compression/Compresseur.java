package net.montaki.compression;

import java.util.Objects;

public abstract class Compresseur {
    public final int[] compresser(int[] data) {
        Objects.requireNonNull(data, "L'image ne doit pas etre null");

        int[] copie = data.clone();

        if (copie.length == 0) {
            return copie;
        }

        return encoder(copie);
    }

    protected abstract int[] encoder(int[] data);
}