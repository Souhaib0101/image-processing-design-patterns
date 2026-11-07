package net.montaki.framework;


import net.montaki.compression.Compresseur;
import net.montaki.strategy.Filtre;

import java.util.Objects;

public class FrameworkImage {
    private Filtre filtre;
    private Compresseur compresseur;

    public FrameworkImage(Filtre filtre, Compresseur compresseur) {
        setFiltre(filtre);
        setCompresseur(compresseur);
    }

    public void setFiltre(Filtre filtre) {
        this.filtre = Objects.requireNonNull(filtre);
    }

    public void setCompresseur(Compresseur compresseur) {
        this.compresseur = Objects.requireNonNull(compresseur);
    }

    public int[] filter(int[] data) {
        Objects.requireNonNull(data, "L'image ne doit pas etre null");
        return filtre.filter(data.clone());
    }

    public int[] compresser(int[] data) {
        return compresseur.compresser(data);
    }
}