package main.java.it.razzolodevs.razzolo.dictionary;

import java.io.*;
import java.util.HashSet;

public class HashDictionary
{
    private final HashSet<String> set;
    private static HashDictionary _instance;

    private HashDictionary()
    {
        this.set = new HashSet<>();

        populateSet();
    }

    private void populateSet()
    {
        final var file = Dictionary.getFile();

        try (final var bufferedReader = new BufferedReader(new FileReader(file.getFD())))
        {
            file.seek(0);

            while (bufferedReader.ready())
                this.set.add(bufferedReader.readLine());
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static HashSet<String> getSet()
    {
        if (_instance == null)
            _instance = new HashDictionary();

        return _instance.set;
    }
}
