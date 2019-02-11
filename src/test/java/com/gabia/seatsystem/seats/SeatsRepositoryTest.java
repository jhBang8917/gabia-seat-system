package com.gabia.seatsystem.seats;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeatsRepositoryTest {
    @Autowired
    SeatsRepository seatsRepository;

    @Test
    public void getSeats() {
        // given
        seatsRepository.save(Seats.builder()
                .location("test")
                .build());

        // when
        List<Seats> seatsList = seatsRepository.findAll();

        // then
        Seats seats = seatsList.get(0);
        assertThat(seats.getLocation(), is("test"));
    }
}
