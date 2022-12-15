package com.ormva_tf.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Embeddable
public class KeyEmplDiplm implements Serializable{

	private static final long serialVersionUID = 1L;
	@ManyToOne
    @JoinColumn(name = "id_employe")
    private Employe employe;
    public Employe getEmploye() {
            return employe;
    }

    public void setEmploye(Employe e) {
            this.employe = e;
    }

    @ManyToOne
    @JoinColumn(name = "id_diplome")
    private Diplome diplome;
    public Diplome getDiplome() {
            return diplome;
    }

    public void setDiplome(Diplome d) {
            this.diplome = d;
    }

}
