package com.architecturelab.repair.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.architecturelab.repair.useCases.ticket.ReparationTicketInputUseCases;
import com.architecturelab.repair.core.domain.ReparationTicketInput;

@RestController
@RequestMapping("/repair")
public class RepairController {
	
	 	@Autowired
	 	private ReparationTicketInputUseCases reparationTicketInputUseCases;

	    @GetMapping("/ticket/{id}")
	    public ResponseEntity<ReparationTicketInput> getTicketById(@PathVariable Long id) {
	        try {
	        	ReparationTicketInput ticketInput = reparationTicketInputUseCases.getById(id);
	            if (ticketInput != null) {
	                return new ResponseEntity<>(ticketInput, HttpStatus.OK);
	            }
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PostMapping("/ticket")
	    public ResponseEntity<ReparationTicketInput> createTicket(@RequestBody ReparationTicketInput ticketInput) {
	        try {
	        	ReparationTicketInput _ticketInput = reparationTicketInputUseCases.create(ticketInput);
	            return new ResponseEntity<>(_ticketInput, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/ticket")
	    public ResponseEntity<ReparationTicketInput> updateTicket(@RequestBody ReparationTicketInput ticketInput) {
	        try {
	        	ReparationTicketInput _ticketInput = reparationTicketInputUseCases.update(ticketInput);
	            if (_ticketInput !=null) {
	                return new ResponseEntity<>(_ticketInput, HttpStatus.OK);
	            } else {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	        } catch (Exception e) {
	            System.out.println(e.fillInStackTrace());
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @GetMapping("/tickets")
	    public ResponseEntity<List<ReparationTicketInput>> getAllTickets() {
	        try {
	            List<ReparationTicketInput> ticketInputs = reparationTicketInputUseCases.getAll();
	            if (ticketInputs.isEmpty()) {
	                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	            }
	            return new ResponseEntity<>(ticketInputs, HttpStatus.OK);
	        } catch (Exception e) {
	            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("/ticket/reparationId/{reparationId}")
	    public ResponseEntity<ReparationTicketInput> getTicketByReparationId(@PathVariable Long reparationId) {
	        try {
	        	ReparationTicketInput ticketInput = reparationTicketInputUseCases.getByReparationId(reparationId);
	            if (ticketInput != null) {
	                return new ResponseEntity<>(ticketInput, HttpStatus.OK);
	            }
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	    
	    @GetMapping("/ticket/activoId/{activoId}")
	    public ResponseEntity<ReparationTicketInput> getTicketByActivoId(@PathVariable Long activoId) {
	        try {
	        	ReparationTicketInput ticketInput = reparationTicketInputUseCases.getByActivoId(activoId);
	            if (ticketInput != null) {
	                return new ResponseEntity<>(ticketInput, HttpStatus.OK);
	            }
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
