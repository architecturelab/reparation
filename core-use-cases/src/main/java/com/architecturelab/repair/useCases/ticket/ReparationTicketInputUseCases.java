package com.architecturelab.repair.useCases.ticket;

import java.util.List;

import org.springframework.stereotype.Service;

import com.architecturelab.repair.core.domain.ReparationTicketInput;

@Service
public interface ReparationTicketInputUseCases {

    public ReparationTicketInput create(ReparationTicketInput itemInput);

    public ReparationTicketInput update(ReparationTicketInput itemInput);

    public List<ReparationTicketInput> getAll();

    public ReparationTicketInput getById(Long id);
    
    public ReparationTicketInput getByReparationId(Long reparationId);
    
    public ReparationTicketInput getByActivoId(Long activoId);
}
