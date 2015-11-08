
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Author:     John Andrew S Duvall
 * Date:       (Insert date here)
 * Project:    (Insert project here)
 */

/**
 *
 * @author JohnAndrew
 */
public class TestMaker {
    public static void main(String args[])
    {
        PrintStream testWriter = null;
        String fileName = "test.txt";
        
        try {
            testWriter = new PrintStream(new File(fileName));
            for (long i = 0; i <  10000; i++)
            {
                testWriter.print(" + " + (long)(Math.random() * 10000));
                if((i%50)==0)
                    testWriter.print("\n");
            }
            for (long i = 0; i < 10000; i++)
            {
                testWriter.print(" *");
                if((i%50)==0)
                    testWriter.print("\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TestMaker.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            testWriter.close();
        }
    }
}
