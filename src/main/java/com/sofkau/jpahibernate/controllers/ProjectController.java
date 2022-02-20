package com.sofkau.jpahibernate.controllers;

import com.sofkau.jpahibernate.models.Project;
import com.sofkau.jpahibernate.services.ProjectServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    ProjectServices projectServices;

    @GetMapping()
    public ArrayList<Project> getProject(){
        return projectServices.getProjects();
    }

    @PostMapping()
    public Project saveProject (@RequestBody Project project){
        return this.projectServices.saveProject(project);
    }

    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable("id") Long id){
        return this.projectServices.findbyProjectID(id);
    }

    @PutMapping("/{id}")
    public String updateProject(@PathVariable("id") long id, @RequestBody Project project){
        return projectServices.updateProject(project, id);
    }

    @DeleteMapping("/{id}")
    public String deleteProjectById(@PathVariable("id") Long id){
        boolean ok = this.projectServices.deleteProject(id);
        if (ok){
            return  "se elliminó el proyecto con id "+ id;
        }else{
            return "No se pudo eliminar el proyecto con id "+id;
        }
    }
}
