package com.appli.springjwt.dto;

import com.appli.springjwt.models.Concourstci;
import com.appli.springjwt.models.Personne;

public class CentreConcoursTCIDto {
    Integer id_centreCTCI;
    String nomCentreCTCI;
    Integer codePostale;
    String nom;
    String prenoms;
    String telephone;


    String nomAdjoint;

    String prenomAdjoint;
    Personne idPersonneAdjoit;

    Personne idPersonne;
    Concourstci idCTCI;

    public CentreConcoursTCIDto(Integer id_centreCTCI, String nomCentreCTCI, Integer codePostale, String nom, String prenoms, String telephone, String nomAdjoint, String prenomAdjoint, Concourstci idCTCI) {
        this.id_centreCTCI = id_centreCTCI;
        this.nomCentreCTCI = nomCentreCTCI;
        this.codePostale = codePostale;
        this.nom = nom;
        this.prenoms = prenoms;
        this.telephone = telephone;
        this.nomAdjoint = nomAdjoint;
        this.prenomAdjoint = prenomAdjoint;
        this.idPersonneAdjoit = idPersonneAdjoit;
        this.idPersonne = idPersonne;
        this.idCTCI = idCTCI;
    }

    public CentreConcoursTCIDto() {
    }

    public Personne getId_PersonneAdjoit() {
        return idPersonneAdjoit;
    }

    public void setId_PersonneAdjoit(Personne id_PersonneAdjoit) {
        this.idPersonneAdjoit = id_PersonneAdjoit;
    }

    public String getNomAdjoint() {
        return nomAdjoint;
    }

    public void setNomAdjoint(String nomAdjoint) {
        this.nomAdjoint = nomAdjoint;
    }

    public String getPrenomAdjoint() {
        return prenomAdjoint;
    }

    public void setPrenomAdjoint(String prenomAdjoint) {
        this.prenomAdjoint = prenomAdjoint;
    }

    public Integer getId_centreCTCI() {
        return id_centreCTCI;
    }

    public void setId_centreCTCI(Integer id_centreCTCI) {
        this.id_centreCTCI = id_centreCTCI;
    }

    public String getNomCentreCTCI() {
        return nomCentreCTCI;
    }

    public void setNomCentreCTCI(String nomCentreCTCI) {
        this.nomCentreCTCI = nomCentreCTCI;
    }

    public Integer getCodePostale() {
        return codePostale;
    }

    public void setCodePostale(Integer codePostale) {
        this.codePostale = codePostale;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Personne getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Personne idPersonne) {
        this.idPersonne = idPersonne;
    }

    public Concourstci getIdCTCI() {
        return idCTCI;
    }

    public void setIdCTCI(Concourstci idCTCI) {
        this.idCTCI = idCTCI;
    }

    @Override
    public String toString() {
        return "CentreConcoursTCIDto{" +
                "id=" + id_centreCTCI +
                ", nomCentreCTCI='" + nomCentreCTCI + '\'' +
                ", codePostale=" + codePostale +
                ", nom='" + nom + '\'' +
                ", prenoms='" + prenoms + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

}
