package com.architecturelab.repair.infra.jpa.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "reparation_tickets")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReparationTicketDomain implements Serializable {
	
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    protected Long id;
 
    @Column(name="reparation_id")
    private Long reparationId;
    
    @Column(name = "activo_id")
    private Long activoId;
    
    @Column(name = "descripcion")
    private String description;

    @Column(name = "usuario_creacion")
    private String usuarioCreacion;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @Column(name = "usuario_modifica")
    private String usuarioModifica;

    @Column(name = "fecha_modifica")
    private Date fechaModifica;

}
