package com.flight.repository;
import org.springframework.data.repository.CrudRepository;

import com.flight.dto.Flight;


public interface FlightRepository extends CrudRepository<Flight, Integer>
{


}
