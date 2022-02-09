package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class AirTrip implements Comparable <AirTrip> {

        private int id;
        private int price;
        private String airportFrom;
        private String airportTo;
        private int travelTimeMin;


        @Override
        public int compareTo(AirTrip o) {
            return price - o.price;
        }
    }

