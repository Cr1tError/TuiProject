package org.mk.tuiproject.repository;

import org.mk.tuiproject.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
