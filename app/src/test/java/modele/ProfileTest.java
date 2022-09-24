package modele;

import junit.framework.TestCase;

public class ProfileTest extends TestCase {
//création profile
    private Profile profil = new Profile(67,165,35,0);
    //resultIMG
    private float img = (float)32.4;
    //message
    private String message = "trop élevé";
    public void testGetImg() {
        assertEquals(img,profil.getImg(),(float)0.1);
    }

    public void testGetMessage() {
        assertEquals(message,profil.getMessage());
    }
}