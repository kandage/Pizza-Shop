package com.company;

/**
 * author k2425199
 */

import java.util.ArrayList;
import java.util.List;

public class FavoriteManager {
    private List<Pizza> favoritePizzas = new ArrayList<>();

    public void addFavorite(Pizza pizza) {
        favoritePizzas.add(pizza);
        System.out.println("Pizza added to favorites!");
    }

    public List<Pizza> getFavorites() {
        return favoritePizzas;
    }
}
