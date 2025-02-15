package com.appli.springjwt.dto;

public class EtudiantDto {

    Integer id;
    String numeroMatricule;
    Short anneeBacc;
    String statusEtudiant;
    Integer idBacc;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumeroMatricule() {
        return numeroMatricule;
    }

    public void setNumeroMatricule(String numeroMatricule) {
        this.numeroMatricule = numeroMatricule;
    }

    public Short getAnneeBacc() {
        return anneeBacc;
    }

    public void setAnneeBacc(Short anneeBacc) {
        this.anneeBacc = anneeBacc;
    }

    public String getStatusEtudiant() {
        return statusEtudiant;
    }

    public void setStatusEtudiant(String statusEtudiant) {
        this.statusEtudiant = statusEtudiant;
    }

    public Integer getIdBacc() {
        return idBacc;
    }

    public void setIdBacc(Integer idBacc) {
        this.idBacc = idBacc;
    }

    @Override
    public String toString() {
        return "EtudiantDto{" +
                "id=" + id +
                ", numeroMatricule='" + numeroMatricule + '\'' +
                ", anneeBacc=" + anneeBacc +
                ", statusEtudiant='" + statusEtudiant + '\'' +
                ", idBacc=" + idBacc +
                '}';
    }
}
