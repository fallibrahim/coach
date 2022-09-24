package modele;

public class Profile {
    //constantes
    private static final int minFemme = 10;
    private static final int maxFemme = 25;
    private static final int minHomme = 15;
    private static final int maxHomme = 30;
    //proprièté
    private int poids;
    private int taille;
    private int age;
    private int sexe;
    private float img;
    private String message;
    public Profile(int poids, int taille, int age, int sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

    public int getPoids() {
        return poids;
    }

    public int getTaille() {
        return taille;
    }

    public int getAge() {
        return age;
    }

    public int getSexe() {
        return sexe;
    }

    public float getImg() {
        return img;
    }

    public String getMessage() {
        return message;
    }
    private void calculIMG()
    {
        float tailleM = ((float)taille)/100;
        this.img =(float)((1.2 * poids/(tailleM * tailleM)) + (0.23 * age) - (10.83 * sexe) - 5.4);
    }
    private void resultIMG()
    {
        int min;
        int max;
        if(sexe == 0)//femme
        {
          min = minFemme;
          max = maxFemme;
        }
        else//homme
        {
        min = minHomme;
        max = maxHomme;
    }
        //message correspondant
        message = "normale";
        if(img < min)
        {
            message = "trop faible";
        }
        else if(img > max)
        {
            message = "trop élevé";
        }
 }
}
