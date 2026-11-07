package net.montaki.adapter;

import net.montaki.legacy.ImplNonStandard;
import net.montaki.strategy.Filtre;

import java.util.Objects;

public class FiltreAdapter implements Filtre {
    private final ImplNonStandard ancienFiltre;
    private final String filterName;

    public FiltreAdapter() {
        this(new ImplNonStandard(), "negatif");
    }

    public FiltreAdapter(ImplNonStandard ancienFiltre, String filterName) {
        this.ancienFiltre = Objects.requireNonNull(ancienFiltre);
        this.filterName = Objects.requireNonNull(filterName);
    }

    @Override
    public int[] filter(int[] data) {
        return ancienFiltre.appliquerFiltre(filterName, data);
    }
}