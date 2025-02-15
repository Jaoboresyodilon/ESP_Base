package com.appli.springjwt.controllers;


import com.appli.springjwt.models.Bacc;
import com.appli.springjwt.repository.BaccRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bacc")
public class BaccController {
    @Autowired
    BaccRepository baccRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('DIRECTION') or hasAuthority('ETUDIANT') or hasRole('ADMIN')")
    public List<Bacc> listBacc() {
        System.out.println("BaccController : listBacc");
        List<Bacc> bacc = baccRepository.findAll();
        return bacc;
    }
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('SCOLARITE') or hasAuthority('PRESIDENT_JURY') or hasAuthority('DIRECTION') or hasAuthority('ETUDIANT') or hasRole('ADMIN')")
    public Bacc Bacc(@PathVariable("id") Integer id) {
        System.out.println("BaccController : Bacc");
        Bacc bacc = baccRepository.findById(id).orElseThrow();
        return bacc;
    }

}
