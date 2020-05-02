package com.flight.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.flight.dto.Flight;
import com.flight.service.FlightService;


@RestController
public class FlightController 
{

@Autowired
FlightService flightService;

@GetMapping("/flight")
private List<Flight> getAllFlights() 
{
return flightService.getAllflights();
}

@GetMapping("/flight/{flightNumber}")
private Flight getFlights(@PathVariable("flightNumber") int flightNumber) 
{
return flightService.getFlightsByFlightNumber(flightNumber);
}

@DeleteMapping("/flight/{flightNumber}")
private void deleteFlight(@PathVariable("flightNumber") int flightNumber) 
{
flightService.delete(flightNumber);
}

@PostMapping("/flights")
private int saveFlight(@RequestBody Flight flights) 
{
flightService.saveOrUpdate(flights);
return flights.getFlightNumber();
}

@PutMapping("/flights")
private Flight update(@RequestBody Flight flights) 
{
flightService.saveOrUpdate(flights);
return flights;
}
}
