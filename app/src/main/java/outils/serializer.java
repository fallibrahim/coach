/*package outils;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

public abstract class serializer {

    public static void serializer(String filename, Object object, Context context)
    {
        try{
            FileOutputStream file = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oos;
            oos = new ObjectOutputStream(file);
            oos.writeObject(object);
            oos.flush();
            oos.close();
        }catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
    public static Object deSerializer(String filename,Context context)
    {
        try{
            FileInputStream file = context.openFileInput(filename);
            ObjectInputStream ois;
            try{
                ois = new ObjectInputStream(file);
               try{
                   Object object = ois.readObject();
                   ois.close();
                   return;
               }catch(ClassNotFoundException e){
                   e.printStackTrace();
               }
            }catch(StreamCorruptedException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return null ;
    }
}
*/