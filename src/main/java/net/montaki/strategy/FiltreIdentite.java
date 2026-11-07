package net.montaki.strategy;

public class FiltreIdentite implements Filtre {
    @Override
    public int[] filter(int[] data) {
        return data.clone();
    }
}