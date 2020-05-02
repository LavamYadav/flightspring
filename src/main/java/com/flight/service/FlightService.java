package com.flight.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flight.dto.Flight;
import com.flight.repository.FlightRepository;


@Service
public class FlightService 
{
@Autowired
FlightRepository flightRepository;

public List<Flight> getAllflights() 
{
List<Flight> flights = new ArrayList<>();
flightRepository.findAll().forEach(flight1 -> flights.add(flight1));
return flights;
}

public Flight getFlightsByFlightNumber(int flightNumber1) 
{
return flightRepository.findById(flightNumber1).get();
}

public void saveOrUpdate(Flight flight) 
{
flightRepository.save(flight);
}


public void delete(int flightNumber1) 
{
flightRepository.deleteById(flightNumber1);
}

public void update(Flight flights, int flightNumber) 
{
flightRepository.save(flights);
}
}