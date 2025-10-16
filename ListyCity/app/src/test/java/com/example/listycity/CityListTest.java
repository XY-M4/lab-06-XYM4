package com.example.listycity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Edmonton", "Alberta");
        assertThrows(IllegalArgumentException.class, () -> cityList.add(city));
    }

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        assertTrue(cityList.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(cityList.hasCity(new City("Toronto", "Ontario")));
    }

    @Test
    void testDeleteRemoves() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);
        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteThrowsWhenNotPresent() {
        CityList cityList = mockCityList();
        City city = new City("NonExistent", "Nowhere");
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(city));
    }

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());
        cityList.add(new City("Vancouver", "British Columbia"));
        assertEquals(1, cityList.countCities());
        cityList.add(new City("Halifax", "Nova Scotia"));
        assertEquals(2, cityList.countCities());
    }

    @Test
    void testGetCitiesSortedOrder() {
        CityList cityList = new CityList();
        cityList.add(new City("Zzz", "P"));
        cityList.add(new City("Abc", "Q"));
        List<City> sorted = cityList.getCities();
        // assert lexicographic order by city name
        assertEquals("Abc", sorted.get(0).getCityName());
        assertEquals("Zzz", sorted.get(1).getCityName());
    }
}
