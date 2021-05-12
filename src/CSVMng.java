import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;


public class CSVMng
{
    private CSVMng () {}

    private static CSVMng instance = null;

    /** singleton
     * verificam daca este deja instantiat
     * @return
     */
    public static CSVMng getInstance ()
    {
        if (instance == null)
        {
            instance = new CSVMng();
        }

        return instance;
    }

    public void saveCSV (Vector <Vector<String>> lines, String fileName)
    {
        FileWriter Writer;

        try
        {
            Writer = new FileWriter(fileName, false);

            for (Vector <String> line : lines)
            {
                for (int i = 0; i < line.size (); i++)
                {
                    Writer.write (line.get (i));
                    if (i != line.size () - 1)
                        Writer.write(",");
                }
                Writer.write ("\n");
            }

            Writer.close();
        } catch (IOException e) {
            System.out.println ("Nu se poate scrie in fisier");
        }
    }


    public Vector <Vector <String>> loadCSV (String fileName)
    {
        Vector <Vector <String>> Values = new Vector <> ();
        File    myObj;
        Scanner myReader;

        try
        {
            myObj = new File(fileName);
            myReader = new Scanner(myObj);

            while (myReader.hasNextLine ())
            {
                String line             = myReader.nextLine ();
                String[] values         = line.split (",");
                Vector<String> Line  = new Vector <> (Arrays.asList (values));
                Values.add (Line);
            }

            myReader.close ();
        } catch (FileNotFoundException e) {
            System.out.println ("Nu se poate citi din fisier");
        }

        return (Values);
    }
}
