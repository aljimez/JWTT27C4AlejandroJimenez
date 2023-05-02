package com.aljimez.T27C4.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aljimez.T27C4.dto.Facultad;

public interface IFacultadDAO  extends  JpaRepository<Facultad, Long> {

}
