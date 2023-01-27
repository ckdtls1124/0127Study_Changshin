package org.spring.security01.repository;

import org.spring.security01.entity.MemberEnt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepo extends JpaRepository<MemberEnt, Long> {

    Optional<MemberEnt> findByEmail(String email);


}
