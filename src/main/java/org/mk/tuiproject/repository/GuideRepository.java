package org.mk.tuiproject.repository;

import org.mk.tuiproject.model.Guide;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuideRepository extends JpaRepository<Guide, Long> {
}
