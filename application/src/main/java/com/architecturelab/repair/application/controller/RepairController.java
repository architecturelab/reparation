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

	    @GetMapping("/reparation/{id}")
	    public ResponseEntity<ReparationTicketInput> getReparationById(@PathVariable Long id) {
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

	    @PostMapping("/reparation")
	    public ResponseEntity<ReparationTicketInput> createReparation(@RequestBody ReparationTicketInput ticketInput) {
	        try {
	        	ReparationTicketInput _ticketInput = reparationTicketInputUseCases.create(ticketInput);
	            return new ResponseEntity<>(_ticketInput, HttpStatus.CREATED);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }

	    @PutMapping("/reparation")
	    public ResponseEntity<ReparationTicketInput> updateReparation(@RequestBody ReparationTicketInput ticketInput) {
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

	    @GetMapping("/reparations")
	    public ResponseEntity<List<ReparationTicketInput>> getAllReparations() {
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
	    
	    @GetMapping("/reparations/ticket/{ticketId}")
	    public ResponseEntity<ReparationTicketInput> getReparationByTicketId(@PathVariable Long ticketId) {
	        try {
	        	ReparationTicketInput ticketInput = reparationTicketInputUseCases.getByTicketId(ticketId);
	            if (ticketInput != null) {
	                return new ResponseEntity<>(ticketInput, HttpStatus.OK);
	            }
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        } catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
