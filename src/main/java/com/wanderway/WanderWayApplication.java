package com.wanderway;

import com.wanderway.models.Hotel;
import com.wanderway.repositories.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WanderWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(WanderWayApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner loadData(HotelRepository hotelRepository) {
//        return args -> {
//            if (hotelRepository.count() == 0) { // Only insert if empty
//                hotelRepository.save(new Hotel(null, "Grand Palace Hotel", "New York", 120, "grand_palace.jpg"));
//                hotelRepository.save(new Hotel(null, "Ocean View Resort", "Miami", 150, "ocean_view.jpg"));
//                hotelRepository.save(new Hotel(null, "Mountain Retreat", "Colorado", 100, "mountain_retreat.jpg"));
//                hotelRepository.save(new Hotel(null, "City Lights Inn", "Chicago", 90, "city_lights.jpg"));
//            }
//        };
//    }
}
