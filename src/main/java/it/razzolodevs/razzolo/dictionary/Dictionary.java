package main.java.it.razzolodevs.razzolo.dictionary;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

public class Dictionary
{
    private final RandomAccessFile file;
    private static Dictionary _instance = null;
    private static final String RESOURCE_DICTIONARY = "dictionary.txt";
    private static final String FILE_ACCESS_MODE = "r";

    private Dictionary()
    {
        final var url = getClass().getClassLoader().getResource(RESOURCE_DICTIONARY);
        if (url == null)
            throw new RuntimeException();

        try
        {
            this.file = new RandomAccessFile(url.getFile(), FILE_ACCESS_MODE);
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static RandomAccessFile getFile()
    {
        if (_instance == null)
            _instance = new Dictionary();

        return _instance.file;
    }
}
