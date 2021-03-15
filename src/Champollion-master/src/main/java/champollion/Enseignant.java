package champollion;

import java.util.ArrayList;

public class Enseignant extends Personne {

    private ArrayList<ServicePrevu> listeService;
    private ArrayList<Intervention> listeIntervention;

    public Enseignant(String nom, String email) {
        super(nom, email);
        this.listeService = new ArrayList<>();
        this.listeIntervention = new ArrayList<>();
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant en "heures équivalent TD" Pour le calcul : 1 heure
     * de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure de TP vaut 0,75h
     * "équivalent TD"
     *
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevues() {
        double total=0;
        if (listeService.isEmpty()) {
            return 0;
        }

        for (int i=0; i<listeService.size();i++) {
            total = (listeService.get(i).getVolumeCM()*1.5) + (listeService.get(i).getVolumeTD()) + (listeService.get(i).getVolumeTP()*0.75) + total;
        }
        int totalInt = (int) total;
        return totalInt;
    }

    /**
     * Calcule le nombre total d'heures prévues pour cet enseignant dans l'UE spécifiée en "heures équivalent TD" Pour
     * le calcul : 1 heure de cours magistral vaut 1,5 h "équivalent TD" 1 heure de TD vaut 1h "équivalent TD" 1 heure
     * de TP vaut 0,75h "équivalent TD"
     *
     * @param ue l'UE concernée
     * @return le nombre total d'heures "équivalent TD" prévues pour cet enseignant, arrondi à l'entier le plus proche
     *
     */
    public int heuresPrevuesPourUE(UE ue) {
        double total=0;
        for (int i=0; i<listeService.size();i++) {
            if (listeService.get(i).getUe().getIntitule() == ue.getIntitule()) {
                total = (listeService.get(i).getVolumeCM() * 1.5) + (listeService.get(i).getVolumeTD()) + (listeService.get(i).getVolumeTP() * 0.75) + total;
            }
        }
        int totalInt = (int) total;
        return totalInt;
    }

    /**
     * Ajoute un enseignement au service prévu pour cet enseignant
     *
     * @param ue l'UE concernée
     * @param volumeCM le volume d'heures de cours magitral
     * @param volumeTD le volume d'heures de TD
     * @param volumeTP le volume d'heures de TP
     */
    public void ajouteEnseignement(UE ue, int volumeCM, int volumeTD, int volumeTP) {
        ServicePrevu service = new ServicePrevu(ue, volumeCM, volumeTD, volumeTP);
        this.listeService.add(service);
    }

    public void ajouteIntervention (Intervention intervention) {
        this.listeIntervention.add(intervention);
    }

    public int resteAPlanifier(UE ue, TypeIntervention type) {
        int total = this.heuresPrevuesPourUE(ue);
        int totalIntervention = 0;
        for (int i=0; i<listeIntervention.size();i++) {
            if (listeIntervention.get(i).getUe().getIntitule() == ue.getIntitule()) {
                totalIntervention = listeIntervention.get(i).getDuree()+totalIntervention;
            }
        }
        return total - totalIntervention;
    }

}
