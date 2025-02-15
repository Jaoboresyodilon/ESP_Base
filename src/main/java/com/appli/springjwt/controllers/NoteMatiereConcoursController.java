package com.appli.springjwt.controllers;

import com.appli.springjwt.dto.NoteMatiereConcoursDto;
import com.appli.springjwt.models.Candidatconcourstci;
import com.appli.springjwt.service.NoteMatiereConcoursService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/concours/note")
public class NoteMatiereConcoursController {
    @Autowired
    NoteMatiereConcoursService noteMatiereConcoursService;

    @PutMapping
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")
    public Candidatconcourstci postNoteConcours(@RequestBody NoteMatiereConcoursDto note){
        System.out.println("NoteMatiereConcoursController : postNoteConcours");
        return noteMatiereConcoursService.creerNote(note);
    }

    @PutMapping("/candidat")
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN') or hasRole('PRESIDENT_JURY')")
    public Candidatconcourstci postNoteConcoursByEtudiant(@RequestBody NoteMatiereConcoursDto note){
        System.out.println("NoteMatiereConcoursController : postNoteConcoursByEtudiant");
        return noteMatiereConcoursService.creerNoteByEtudiant(note);
    }

    @GetMapping("/concours/{idConcours}/centre/{idCentre}")
    /*@PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")*/
    public NoteMatiereConcoursDto getNoteConcours(@PathVariable("idConcours") Integer idConcours, @PathVariable("idCentre") Integer idCentre){
        System.out.println("NoteMatiereConcoursController : getNoteConcours");
        try {
            return noteMatiereConcoursService.getNote(idConcours, idCentre);
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
}
