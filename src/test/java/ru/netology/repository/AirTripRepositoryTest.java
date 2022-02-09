package ru.netology.repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.AirTrip;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class AirTripRepositoryTest {
    private AirTripRepository repository = new AirTripRepository();
    private AirTrip first = new AirTrip(1, 10_000, "SVO", "LED", 60);
    private AirTrip second = new AirTrip(2, 20_000, "SVO", "LED", 60);
    private AirTrip third = new AirTrip(3, 5000, "GOJ", "DME", 75);

    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
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
        AirTrip[] expected = new AirTrip[]{second, third};
        AirTrip[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

}