package controleur;

import modele.Profile;

public final class Controle {
    private static Controle instance = null;
    private Profile profil;

    /**
     * constructeur private
      */
private Controle()
{
    super();
}

    /**
     *
     * @return instance
     */
    public static final Controle getInstance()
{
    if(Controle.instance == null)
    {
        Controle.instance = new Controle();
    }
    return Controle.instance;
}

    /**
     * creation de profile
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour Homme , 0 pour Femme
     */
    public void createProfil(int poids, int taille, int age, int sexe)
{
    profil = new Profile(poids, taille, age, sexe);
}

    /**
     * recuperation img de profile
     * @return img
     */
 public float getImg()
 {
     return profil.getImg();
 }

    /**
     * recuperation message de profile
     * @return message
     */
 public String getMessage()
 {
     return profil.getMessage();
 }
}
