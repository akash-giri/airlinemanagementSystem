package com.airline.airlinemanagement.controller;

import com.airline.airlinemanagement.dto.response.PassengerSummaryResponse;
import com.airline.airlinemanagement.service.AdminPassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin/flights")
@RequiredArgsConstructor
public class AdminPassengerController {

    private AdminPassengerService adminPassengerService;

    @GetMapping("/passengers/{flightId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<PassengerSummaryResponse>> getAllPassengers(@PathVariable Long flightId) {
        return ResponseEntity.ok(adminPassengerService.getPassengersByFlight(flightId));
    }
}
