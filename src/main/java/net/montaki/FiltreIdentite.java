package net.montaki;

public class FiltreIdentite implements Filtre {
    @Override
    public int[] filter(int[] data) {
        return data.clone();
    }
}