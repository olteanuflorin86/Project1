package com.agileflorin.ppmtool.repositories;

import com.agileflorin.ppmtool.domain.Project;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {

    Project findByProjectIdentifier(String projectIdentifier);

    Iterable<Project> findAllByProjectLeader(String username);

}

