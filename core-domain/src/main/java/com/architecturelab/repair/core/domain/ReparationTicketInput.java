package com.architecturelab.repair.core.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparationTicketInput {

	 private Long id;
	 
	 private Long ticketId;
	 
	 private String description;
	 
	 private String usuarioCreacion;
	 
	 private Date fechaCreacion;
	 
	 private String usuarioModifica;
	 
	 private Date fechaModifica;
}
