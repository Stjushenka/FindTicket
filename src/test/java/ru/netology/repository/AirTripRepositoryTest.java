package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTrip;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AirTripRepositoryTest {
    private AirTripRepository repository = new AirTripRepository();
    private AirTrip first = new AirTrip(1, 10000, "SVO", "LED", 60);
    private AirTrip second = new AirTrip(2, 15000, "SVO", "LED", 60);
    private AirTrip third = new AirTrip(3, 5000, "GOJ", "DME", 75);
    private AirTrip forth = new AirTrip(4, 25000, "VKO", "NSK", 240);
    private AirTrip fifth = new AirTrip(6, 0, "null", "null", 0);
    private AirTrip sixth = new AirTrip(5, 0, "DME", "null", 0);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(forth);
        repository.save(fifth);
        repository.save(sixth);
    }

    @Test
    public void shouldThrowCheckedException() {
        int idToRemove = 4;
        assertThrows(NotFoundException.class, () -> repository.removeById(idToRemove));
    }

    @Test
    public void shouldNotThrowCheckedException() {
        int idToRemove = 1;
        repository.removeById(idToRemove);
        AirTrip[] expected = new AirTrip[]{second, third, forth, fifth, sixth};
        AirTrip[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotThrowCheckedException1() {
        int idToRemove = 5;
        repository.removeById(idToRemove);
        AirTrip[] expected = new AirTrip[]{first, second, third, forth, fifth};
        AirTrip[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }


}