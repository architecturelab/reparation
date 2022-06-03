package com.architecturelab.repair.infra.jpa.repository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import com.architecturelab.repair.infra.jpa.dao.ReparationTicketDao;
import com.architecturelab.repair.infra.jpa.domain.ReparationTicketDomain;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
@EnableJpaRepositories(basePackages = {"com.architecturelab.repair"})
@EntityScan("com.architecturelab.repair")
public class ReparationTicketJpaRepositoryImpl implements ReparationTicketJpaRepository{
	
	@Autowired
    private ReparationTicketDao reparationTicketDao;

    @Override
    public ReparationTicketDomain save(ReparationTicketDomain entity) {
        return reparationTicketDao.save(entity);
    }

    @Override
    public Iterable<ReparationTicketDomain> getAll() {
        return reparationTicketDao.findAll();
    }

    @Override
    public Optional<ReparationTicketDomain> getById(Long id) {
        return reparationTicketDao.findById(id);
    }

	@Override
	public Optional<ReparationTicketDomain> getByTicketId(Long activoId) {
		return reparationTicketDao.getByTicketId(activoId);
	}

}
