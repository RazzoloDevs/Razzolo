package main.java.it.razzolodevs.razzolo.model;

import main.java.it.razzolodevs.razzolo.Dictionary;

import java.io.*;
import java.util.HashSet;

public class HashDictionary {
    private static HashSet<String> hashDictionary;

    private HashDictionary() {
        hashDictionary = new HashSet<>();

        final RandomAccessFile randomAccessFile = Dictionary.getInstance();
        final BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(randomAccessFile.getFD()));
            randomAccessFile.seek(0);
            while(bufferedReader.ready()){
                final String s = bufferedReader.readLine();
                hashDictionary.add(s);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static HashSet<String> getInstance() {
        if(hashDictionary == null)
            new HashDictionary();
        return hashDictionary;
    }
}
