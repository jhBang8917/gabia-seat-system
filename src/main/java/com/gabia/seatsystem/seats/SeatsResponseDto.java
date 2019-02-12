package com.gabia.seatsystem.seats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
public class SeatsResponseDto {
    private Long id;
    private String location;
    private String userName;
    private String userId;

    public SeatsResponseDto(Seats entity) {
        id = entity.getId();
        location = entity.getLocation();
        userId = entity.getUserId();
        userName = entity.getUserName();
    }
}
