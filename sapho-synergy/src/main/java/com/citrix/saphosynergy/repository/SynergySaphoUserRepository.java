package com.citrix.saphosynergy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citrix.saphosynergy.model.SynergySaphoUser;

@Repository
public interface SynergySaphoUserRepository extends JpaRepository<SynergySaphoUser, Long> {
}
