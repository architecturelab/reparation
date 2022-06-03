package com.architecturelab.repair.infra.jpa.repository;

import java.util.Optional;

import com.architecturelab.repair.infra.jpa.domain.ReparationTicketDomain;

public interface ReparationTicketJpaRepository {
    public ReparationTicketDomain save(ReparationTicketDomain entity);

    public Iterable<ReparationTicketDomain> getAll();

    public Optional<ReparationTicketDomain> getById(Long id);
    
    public Optional<ReparationTicketDomain> getByTicketId(Long ticketId);

}
