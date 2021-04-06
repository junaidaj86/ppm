package io.tech.simplified.ppmtool.repository;

import io.tech.simplified.ppmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    Iterable<Project> findAllById(Iterable<Long> iterable);

}
