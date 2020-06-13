package com.agileflorin.ppmtool.repositories;

import com.agileflorin.ppmtool.domain.ProjectTask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectTaskRepository extends CrudRepository<ProjectTask, Long> {

    List<ProjectTask> findByProjectIdentifierOrderByPriority(String Identifier);

    ProjectTask findByProjectSequence(String sequence);
}
