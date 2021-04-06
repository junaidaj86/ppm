package io.tech.simplified.ppmtool.web;

import io.tech.simplified.ppmtool.domain.Project;
import io.tech.simplified.ppmtool.services.ProjectService;
import io.tech.simplified.ppmtool.services.ValidationErrorMappingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

    @Autowired
    ProjectService projectService;
    @Autowired
    ValidationErrorMappingService validationErrorMappingService;

    @PostMapping("/save")
    public ResponseEntity<?> createNewProject(@Valid @RequestBody Project project, BindingResult result){
        ResponseEntity<?> errorMap = validationErrorMappingService.errorMapper(result);
        if(errorMap != null){
            return errorMap;
        }else{
            Project pp = projectService.saveORUpdateProject(project);
            return new ResponseEntity<>(pp, HttpStatus.CREATED);
        }

    }
}
