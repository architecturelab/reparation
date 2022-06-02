package com.architecturelab.repair.useCases.ticket;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.architecturelab.repair.core.domain.ReparationTicketInput;
import com.architecturelab.repair.infra.jpa.domain.ReparationTicketDomain;
import com.architecturelab.repair.infra.jpa.repository.ReparationTicketJpaRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReparationTicketInputUseCasesImpl implements ReparationTicketInputUseCases{

    @Autowired
    private ReparationTicketJpaRepository reparationTicketJpaRepository;

    @Override
    public ReparationTicketInput create(ReparationTicketInput ticketInput) {
    	ReparationTicketDomain ticket = reparationTicketJpaRepository.save(new ReparationTicketDomain(
    			ticketInput.getId(),
    			ticketInput.getReparationId(),
                ticketInput.getActivoId(),  
                ticketInput.getDescription(),
                ticketInput.getUsuarioCreacion(),
                ticketInput.getFechaCreacion(),
                ticketInput.getUsuarioModifica(),
                ticketInput.getFechaModifica()
        ));
    	ReparationTicketInput input = new ReparationTicketInput(
                ticket.getId(),
                ticket.getReparationId(),
                ticket.getActivoId(),
                ticket.getDescription(),
                ticket.getUsuarioCreacion(),
                ticket.getFechaCreacion(),
                ticket.getUsuarioModifica(),
                ticket.getFechaModifica()
        );
        return input;
    }

    @Override
    public ReparationTicketInput update(ReparationTicketInput ticketInput) {
        Optional<ReparationTicketDomain> ticketData = reparationTicketJpaRepository.getById(ticketInput.getReparationId());
        if (ticketData.isPresent()){
        	ReparationTicketDomain ticket = ticketData.get();
            ticket.setActivoId(ticketInput.getActivoId());
            ticket.setDescription(ticketInput.getDescription());
            ticket.setUsuarioCreacion(ticketInput.getUsuarioCreacion());
            ticket.setFechaCreacion(ticketInput.getFechaCreacion());
            ticket.setUsuarioModifica(ticketInput.getUsuarioModifica());
            ticket.setFechaModifica(ticketInput.getFechaModifica());

            ReparationTicketDomain updated = reparationTicketJpaRepository.save(ticket);
            ReparationTicketInput input = new ReparationTicketInput(
            		updated.getId(),
            		updated.getReparationId(),
                    updated.getActivoId(),
                    updated.getDescription(),
                    updated.getUsuarioCreacion(),
                    updated.getFechaCreacion(),
                    updated.getUsuarioModifica(),
                    updated.getFechaModifica()   
            );
            return input;
        }
        return null;
    }

    @Override
    public List<ReparationTicketInput> getAll() {
        List<ReparationTicketDomain> tickets = (List<ReparationTicketDomain>) reparationTicketJpaRepository.getAll();

        List<ReparationTicketInput> inputs = new ArrayList<ReparationTicketInput>();

        tickets.forEach(i -> {
        	ReparationTicketInput ticket = new ReparationTicketInput(
        			i.getId(),
                    i.getReparationId(),
                    i.getActivoId(),
                    i.getDescription(),
                    i.getUsuarioCreacion(),
                    i.getFechaCreacion(),
                    i.getUsuarioModifica(),
                    i.getFechaModifica()
            );
            inputs.add(ticket);
        });
        return inputs;
    }

    @Override
    public ReparationTicketInput getById(Long id) {
        Optional<ReparationTicketDomain> ticketData = reparationTicketJpaRepository.getById(id);
        if (ticketData.isPresent()){
        	ReparationTicketDomain ticket = ticketData.get();
        	ReparationTicketInput input = new ReparationTicketInput(
        			ticket.getId(),
                    ticket.getReparationId(),
                    ticket.getActivoId(),
                    ticket.getDescription(),
                    ticket.getUsuarioCreacion(),
                    ticket.getFechaCreacion(),
                    ticket.getUsuarioModifica(),
                    ticket.getFechaModifica()
            );
            return input;
        }
        return null;
    }

	@Override
	public ReparationTicketInput getByReparationId(Long reparationId) {
        Optional<ReparationTicketDomain> ticketData = reparationTicketJpaRepository.getByReparationId(reparationId);
        if (ticketData.isPresent()){
        	ReparationTicketDomain ticket = ticketData.get();
        	ReparationTicketInput input = new ReparationTicketInput(
        			ticket.getId(),
                    ticket.getReparationId(),
                    ticket.getActivoId(),
                    ticket.getDescription(),
                    ticket.getUsuarioCreacion(),
                    ticket.getFechaCreacion(),
                    ticket.getUsuarioModifica(),
                    ticket.getFechaModifica()
            );
            return input;
        }
		return null;
	}
	
	@Override
	public ReparationTicketInput getByActivoId(Long activoId) {
        Optional<ReparationTicketDomain> ticketData = reparationTicketJpaRepository.getByActivoId(activoId);
        if (ticketData.isPresent()){
        	ReparationTicketDomain ticket = ticketData.get();
        	ReparationTicketInput input = new ReparationTicketInput(
        			ticket.getId(),
                    ticket.getReparationId(),
                    ticket.getActivoId(),
                    ticket.getDescription(),
                    ticket.getUsuarioCreacion(),
                    ticket.getFechaCreacion(),
                    ticket.getUsuarioModifica(),
                    ticket.getFechaModifica()
            );
            return input;
        }
		return null;
	}
}
