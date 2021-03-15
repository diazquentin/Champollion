package champollion;

import java.util.Date;

public class Intervention {

    private UE ue;
    private TypeIntervention type;
    private Date debut;
    private int duree;
    private boolean annulee;
    private int heureDebut;

    public Intervention(UE ue, TypeIntervention type, Date debut, int duree, boolean annulee, int heureDebut) {
        this.ue = ue;
        this.type = type;
        this.debut = debut;
        this.duree = duree;
        this.annulee = annulee;
        this.heureDebut = heureDebut;
    }

    public UE getUe() {
        return ue;
    }

    public void setUe(UE ue) {
        this.ue = ue;
    }

    public TypeIntervention getType() {
        return type;
    }

    public void setType(TypeIntervention type) {
        this.type = type;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public boolean isAnnulee() {
        return annulee;
    }

    public void setAnnulee(boolean annulee) {
        this.annulee = annulee;
    }

    public int getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(int heureDebut) {
        this.heureDebut = heureDebut;
    }
}
