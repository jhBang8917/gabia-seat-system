package com.gabia.seatsystem.seats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
public class SeatsController {
    private SeatsRepository seatsRepository;

    @PostMapping("/api/seats")
    public void saveSeats(@RequestBody SeatsRequestDto dto) {
        seatsRepository.save(dto.toEntity());
    }

    @GetMapping("/api/seats/{id}")
    public SeatsResponseDto getSeat(@PathVariable("id") Long id) {
        Seats seats = seatsRepository.getOne(id);
        SeatsResponseDto dto = new SeatsResponseDto(seats);
        return dto;
    }

    @GetMapping("/api/seats")
    public List<Seats> getSeatList() {
        List<Seats> list = seatsRepository.findAll();
        return list;
    }
}
