package com.gabia.seatsystem.seats;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Seats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String location;

    @Column
    private String userName;

    @Column
    private String userId;

    @Builder
    public Seats(String location, String userName, String userId) {
        this.location = location;
        this.userName = userName;
        this.userId = userId;
    }
}
