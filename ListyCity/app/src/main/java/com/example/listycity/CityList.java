package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maintains a list of unique City objects.
 */
public class CityList {
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds the provided city if it does not already exist in the list.
     *
     * @param city city to add
     * @throws IllegalArgumentException if city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists: " + city);
        }
        cities.add(city);
    }

    /**
     * Check whether the provided city exists in the list.
     *
     * @param city the city to check
     * @return true if the city exists in the list, false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes the provided city from the list if present.
     *
     * @param city the city to delete
     * @throws IllegalArgumentException if the city does not exist in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException("City not found: " + city);
        }
    }

    /**
     * Return a sorted copy of the internal city list.
     *
     * @return sorted List<City> (caller may mutate this copy)
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    /**
     * Return the number of cities currently in the list.
     *
     * @return count of cities
     */
    public int countCities() {
        return cities.size();
    }
}
