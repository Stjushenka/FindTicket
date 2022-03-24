package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTrip;
import ru.netology.repository.AirTripRepository;

import static org.junit.jupiter.api.Assertions.*;

class AirRouteManagerTest {
    private AirTripRepository repository = new AirTripRepository();
    private AirTripManager manager = new AirTripManager(repository);
    private AirTrip first = new AirTrip(1, 10000, "SVO", "LED", 60);
    private AirTrip second = new AirTrip(2, 15000, "SVO", "LED", 60);
    private AirTrip third = new AirTrip(3, 5000, "GOJ", "DME", 75);
    private AirTrip forth = new AirTrip(4, 25000, "VKO", "NSK", 240);
    private AirTrip fifth = new AirTrip(6,0,"null", "null",0);
    private AirTrip sixth = new AirTrip(5, 0, "DME", "null", 0);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
    }

    @Test
    public void shouldNotFound() {
        String airportFrom = "VKO";
        String airportTo = "DME";

        AirTrip[] expected = new AirTrip[0];
        AirTrip[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundFirst() {
        String airportFrom = "SVO";
        String airportTo = "PAR";

        AirTrip[] expected = new AirTrip[0];
        AirTrip[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFoundSecond() {
        String airportFrom = "PAR";
        String airportTo = "CDG";

        AirTrip[] expected = new AirTrip[0];
        AirTrip[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFoundAll() {
        String airportFrom = "SVO";
        String airportTo = "LED";

        AirTrip[] expected = new AirTrip[]{first, second};
        AirTrip[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNull() {
        String airportFrom = "null";
        String airportTo = "null";
        AirTrip[] expected = new AirTrip[]{fifth};
        AirTrip[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindOne() {
        String airportFrom = "DME";
        String airportTo = "null";
        AirTrip[] expected = new AirTrip[]{sixth};
        AirTrip[] actual = manager.findAll(airportFrom, airportTo);
        assertArrayEquals(expected, actual);

    }
}