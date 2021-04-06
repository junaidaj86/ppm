package io.tech.simplified.ppmtool.services;

import io.tech.simplified.ppmtool.domain.Project;
import io.tech.simplified.ppmtool.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository projectRepository;

    public Project saveORUpdateProject(Project project){
        return projectRepository.save(project);
    }
}
