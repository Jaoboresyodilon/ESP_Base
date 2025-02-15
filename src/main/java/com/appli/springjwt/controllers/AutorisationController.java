package com.appli.springjwt.controllers;

import com.appli.springjwt.dto.AuthentificationDto;
import com.appli.springjwt.dto.AutorisationDto;
import com.appli.springjwt.service.AutorisationInscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/autorisation")

public class AutorisationController {
    @Autowired
    AutorisationInscriptionService autorisationInscriptionService;

    @PostMapping("/concours/{id}")
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE')  or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")
    public void postAutorisation(@PathVariable("id") Integer id , @RequestBody AutorisationDto autorisationDto){
        System.out.println("AutorisationController : postAutorisation");
        autorisationInscriptionService.creerAutorisation(id, autorisationDto);
    }

    @PostMapping("/concours/{id}/attente")
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE')  or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")
    public void postAutorisationAttente(@PathVariable("id") Integer id , @RequestBody AutorisationDto autorisationDto){
        System.out.println("AutorisationController : postAutorisation");
        autorisationInscriptionService.creerAutorisationAttente(id, autorisationDto);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")
    public ArrayList<AutorisationDto> listAutorisation() {
        System.out.println("AutorisationController : listAutorisation");
        return autorisationInscriptionService.ListAutorisation();
    }

    @GetMapping("/personne/{idPersonne}/au/{idAU}")
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('ETUDIANT') or hasRole('ADMIN')")
    public AutorisationDto listAutorisationById(@PathVariable("idPersonne") Integer idPersonne, @PathVariable("idAU") Integer idAU) {
        System.out.println("AutorisationController : listAutorisationById");
        return autorisationInscriptionService.listAutorisationById(idPersonne,idAU);
    }

    @GetMapping("/niveau/{idNiveau}/au/{idAU}")
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")
    public ArrayList<AutorisationDto> listAutorisationNiveau(@PathVariable("idNiveau") Integer idNiveau,@PathVariable("idAU") Integer idAU) {
        System.out.println("AutorisationController : listAutorisationNiveau");
        return autorisationInscriptionService.ListAutorisationNiveau(idNiveau,idAU);
    }

    @PutMapping("{id}")
    @PreAuthorize("hasRole('USER') or hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasRole('ADMIN')")
    public AuthentificationDto putAutorisation(@PathVariable("id") Integer id, @RequestBody AutorisationDto autorisationDto){
        System.out.println("AutorisationController : putAutorisation");
        return autorisationInscriptionService.modifierAutorisation(id,autorisationDto);
    }

    @PutMapping("/etudiant/niveau/{idNiveau}/annee/{idAnnee}")
    @PreAuthorize("hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('RESPONSABLE_PARCOURS') or hasAuthority('RESPONSABLE_MENTION')")
    public void putAutorisationEtudiant(@PathVariable("idNiveau") Integer idNiveau,@PathVariable("idAnnee") Integer idAnnee, @RequestBody ArrayList<AutorisationDto> autorisationDto){
        System.out.println("AutorisationController : putAutorisationEtudiant");
        autorisationInscriptionService.creerAutorisationEtudiant(idNiveau,idAnnee,autorisationDto);
    }

}
