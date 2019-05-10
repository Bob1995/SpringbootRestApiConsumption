package com.citrix.saphosynergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citrix.saphosynergy.model.SynergyApp;

@Repository
public interface SynergyAppsRepository extends JpaRepository<SynergyApp, Long> {
}

