package com.wanderway.controllers;

import com.wanderway.models.Booking;
import com.wanderway.models.Hotel;
import com.wanderway.repositories.BookingRepository;
import com.wanderway.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private HotelRepository hotelRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping
    public String showHotels(Model model) {
        model.addAttribute("hotels", hotelRepository.findAll());
        return "hotels";
    }

    @GetMapping("/reserve/{id}")
    public String reserveHotel(@PathVariable Long id, Model model) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow();
        Booking booking = new Booking();
        booking.setHotel(hotel);
        model.addAttribute("booking", booking);
        return "reserve";
    }

    @PostMapping("/reserve")
    public String confirmBooking(@ModelAttribute Booking booking) {
        booking.setTotalPrice(booking.getNights() * booking.getHotel().getPricePerNight());
        bookingRepository.save(booking);
        return "redirect:/booking/confirmation";
    }

    @GetMapping("/confirmation")
    public String bookingConfirmation(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "confirmation";
    }
}
