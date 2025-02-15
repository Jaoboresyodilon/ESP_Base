package com.appli.springjwt.controllers;

import com.appli.springjwt.dto.CursusDto;
import com.appli.springjwt.service.CursusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/cursus")
public class CursusController {
    @Autowired
    CursusService cursusService;

    @PostMapping
    @PreAuthorize("hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('ETUDIANT') or hasRole('ADMIN')")
    public void post(@RequestBody CursusDto cursusDto){
        System.out.println("CursusController : post");
        cursusService.save(cursusDto);
    }

    @GetMapping("/definition-parcours/{id}")
    @PreAuthorize("hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('DIRECTION') or hasAuthority('RESPONSABLE_PARCOURS') or hasAuthority('RESPONSABLE_MENTION') or hasRole('ADMIN')")
    public ArrayList<CursusDto> get(@PathVariable("id") Integer id){
        System.out.println("CursusController : get");
        return  cursusService.getById(id);
    }

    @PutMapping("/inscription-pedagogique")
    @PreAuthorize("hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('ETUDIANT') or hasAuthority('RESPONSABLE_PARCOURS') or hasAuthority('RESPONSABLE_MENTION') or hasRole('ADMIN')")
    public void put(@RequestBody ArrayList<CursusDto> cursusDto){
        System.out.println("CursusController : put");
        cursusService.update(cursusDto);
    }

}
