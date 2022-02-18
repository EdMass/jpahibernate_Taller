package com.sofkau.jpahibernate.services;

import com.sofkau.jpahibernate.models.Project;
import com.sofkau.jpahibernate.repository.IProjectJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProjectServices {
    @Autowired
    IProjectJpaRepository iProjectJpaRepository;

    public ArrayList<Project> getProjects(){
        return (ArrayList<Project>) iProjectJpaRepository.findAll();
    }

    public Project saveProject (Project project){
        return iProjectJpaRepository.save(project);
    }

    public Optional<Project> findbyProjectID(Long id){
        return iProjectJpaRepository.findById(id);
    }

    public boolean deleteProject(Long id) {
        try {
            iProjectJpaRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    public void updateProject(Project project){
        iProjectJpaRepository.save(project);
    }
}


