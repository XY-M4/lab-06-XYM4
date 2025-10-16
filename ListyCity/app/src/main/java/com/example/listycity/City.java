package com.example.listycity;

import androidx.annotation.NonNull;

/**
 * A simple value class representing a city and its province/state.
 */
public class City implements Comparable<City> {
    /**
     * Name of the city.
     */
    private final String city;

    /**
     * Province or state of the city.
     */
    private final String province;

    /**
     * Construct a City.
     *
     * @param city     the city name (not null)
     * @param province the province/state name (not null)
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Get the city name.
     *
     * @return the city name
     */
    public String getCityName() {
        return city;
    }

    /**
     * Get the province/state name.
     *
     * @return the province/state name
     */
    public String getProvinceName() {
        return province;
    }

    /**
     * Compare two City objects by their city name (lexicographically).
     *
     * @param other the other city to compare to
     * @return negative if {@code this < other}, 0 if equal, positive if {@code this > other}
     */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }

    /**
     * Two City objects are equal when both city and province strings match.
     *
     * @param o other object
     * @return true if both city and province are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City city1 = (City) o;
        return city.equals(city1.city) && province.equals(city1.province);
    }

    /**
     * Hash code consistent with {@link #equals(Object)}.
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        int result = city.hashCode();
        result = 31 * result + province.hashCode();
        return result;
    }

    /**
     * Human-friendly string representation of the city.
     *
     * @return "City, Province"
     */
    @NonNull
    @Override
    public String toString() {
        return city + ", " + province;
    }
}
