package com.gabia.seatsystem.seats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class SeatsResponseDto {
    private Long id;
    private String location;

    public SeatsResponseDto(Seats entity) {
        id = entity.getId();
        location = entity.getLocation();
    }
}
