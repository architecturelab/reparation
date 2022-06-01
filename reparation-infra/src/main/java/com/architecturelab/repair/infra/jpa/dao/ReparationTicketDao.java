package com.architecturelab.repair.infra.jpa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.architecturelab.repair.infra.jpa.domain.ReparationTicketDomain;

@Repository
public interface ReparationTicketDao extends CrudRepository<ReparationTicketDomain, Long>{
	
	@Query("SELECT u FROM ReparationTicketDomain u WHERE u.reparationId = ?1")
	Optional<ReparationTicketDomain> getByReparationId(Long reparationId);
	
	@Query("SELECT u FROM ReparationTicketDomain u WHERE u.activoId = ?1")
	Optional<ReparationTicketDomain> getByActivoId(Long activoId);

}
