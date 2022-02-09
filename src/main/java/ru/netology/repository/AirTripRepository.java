package ru.netology.repository;

import ru.netology.domain.AirTrip;
import ru.netology.exception.NotFoundException;

public class AirTripRepository {
    private AirTrip[] items = new AirTrip[0];

    public void save(AirTrip item) {
        int length = items.length + 1;
        AirTrip[] tmp = new AirTrip[length];
        System.arraycopy(items, 0, tmp, 0, items.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = item;
        items = tmp;
    }

    public AirTrip[] findAll() {
        return items;
    }


    public AirTrip findById(int id) {
        for (AirTrip product : items) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public void removeById(int id) {
        if (findById(id) == null) {
            throw new NotFoundException("Element with id " + id + " not found");
        }
        int length = items.length - 1;
        AirTrip[] tmp = new AirTrip[length];
        int index = 0;
        for (AirTrip item : items) {
            if (item.getId() != id) {
                tmp[index] = item;
                index++;
            }
        }
        items = tmp;
    }

}