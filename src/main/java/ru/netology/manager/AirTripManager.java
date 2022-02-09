package ru.netology.manager;

import ru.netology.domain.AirTrip;
import ru.netology.repository.AirTripRepository;

import java.util.Arrays;

public class AirTripManager {
    private AirTripRepository repository;

    public AirTripManager(AirTripRepository repository) {
        this.repository = repository;
    }

    public void add(AirTrip item) {
        repository.save(item);
    }

    public AirTrip[] findAll(String airportFrom, String airportTo) {
        AirTrip[] result = new AirTrip[0];
        for (AirTrip airTrip : repository.findAll()) {
            if (airTrip.getAirportFrom().equalsIgnoreCase(airportFrom) && airTrip.getAirportTo().equalsIgnoreCase(airportTo)) {
                AirTrip[] tmp = new AirTrip[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = airTrip;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

}
