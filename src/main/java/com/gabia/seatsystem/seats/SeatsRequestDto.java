package com.gabia.seatsystem.seats;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatsRequestDto {
    private String location;

    private String userId;

    private String userName;

    public Seats toEntity() {
        return Seats.builder()
                .location(location)
                .userId(userId)
                .userName(userName)
                .build();
    }
}
