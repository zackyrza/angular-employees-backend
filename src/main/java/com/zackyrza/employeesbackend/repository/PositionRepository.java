package com.zackyrza.employeesbackend.repository;

import com.zackyrza.employeesbackend.model.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PositionRepository extends JpaRepository<Position, Long> {

}
