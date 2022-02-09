package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTrip;
import ru.netology.repository.AirTripRepository;

import static org.junit.jupiter.api.Assertions.*;

class AirRouteManagerTest {
    private AirTripRepository repository = new AirTripRepository();
    private AirTripManager manager = new AirTripManager(repository);
    private AirTrip first = new AirTrip(1, 10_000, "SVO", "LED", 60);
    private AirTrip second = new AirTrip(2, 20_000, "SVO", "LED", 60);
    private AirTrip third = new AirTrip(3, 5000, "GOJ", "DME", 75);
    private AirTrip forth = new AirTrip(4, 25_000, "VKO", "NSK", 240);

    @BeforeEach
    public void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
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
}