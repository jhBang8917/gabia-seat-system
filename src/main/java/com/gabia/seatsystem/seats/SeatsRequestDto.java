package com.gabia.seatsystem.seats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatsRequestDto {
    private String location;

    public Seats toEntity() {
        return Seats.builder()
                .location(location)
                .build();
    }
}
