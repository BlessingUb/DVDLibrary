/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.Dvd;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author blessingubogu
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    public static final String LIBRARY_FILE = "library.txt";
    public static final String DELIMITER = "::";
    
    private Map<String, Dvd> dvds = new HashMap<>();

    /**
     *
     * @param title
     * @param dvd
     * @return
     * @throws DvdLibraryDaoException
     */
    @Override
    public Dvd createDvd(String title, Dvd dvd) 
      throws DvdLibraryDaoException {
        loadLibrary();
        Dvd newDvd = dvds.put(title, dvd);
        writeLibrary();
        return newDvd;
    }

    @Override
    public List<Dvd> getAllDvds()
      throws DvdLibraryDaoException {
        loadLibrary();
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title)
      throws DvdLibraryDaoException {
        loadLibrary();
        return dvds.get(title);
    }

    @Override
    public Dvd deleteDvd(String title)
      throws DvdLibraryDaoException {
        loadLibrary();
        Dvd deletedDvd = dvds.remove(title);
        writeLibrary();
        return deletedDvd;
    }
    
    // able to edit an exisiting dvd
//    @Override
//    public Dvd editDvd(String title) {
//        Dvd editedDvd = dvds.put(title);
//        return editedDvd;
//    }
//    
    private void loadLibrary() throws DvdLibraryDaoException {
    Scanner scanner;

    try {
        // Create Scanner for reading the file
        scanner = new Scanner(
                new BufferedReader(
                        new FileReader(LIBRARY_FILE)));
    } catch (FileNotFoundException e) {
        throw new DvdLibraryDaoException(
                "-_- Could not load roster data into memory.", e);
    }
    // currentLine holds the most recent line read from the file
    String currentLine;
    // currentDvd holds the most recent dvd unmarshalled
    Dvd currentDvd;
    // Go through LIBRARY_FILE line by line, decoding each line into a 
    // Dvd object by calling the unmarshallDvd method.
    // Process while we have more lines in the file
    while (scanner.hasNextLine()) {
        // get the next line in the file
        currentLine = scanner.nextLine();
        // unmarshall the line into a Dvd
        currentDvd = unmarshallDvd(currentLine);

        //use the dvd title as the map key for our dvd object.
        // Put currentDvd into the map using title as the key
        dvds.put(currentDvd.getTitle(), currentDvd());
    }
    // close scanner
    scanner.close();
    }
    
    
    private String marshallDvd(Dvd aDvd){
    // turn a Dvd object into a line of text for our file.
    //  get out each property,
    // and concatenate with our DELIMITER as a kind of spacer. 

    // Start with the dvd title.
    String dvdAsText = aDvd.getTitle() + DELIMITER;

    // add the rest of the properties in the correct order:

    // Release Date
    dvdAsText += aDvd.getReleaseDate() + DELIMITER;

    // MPAA Rating
    dvdAsText += aDvd.getMpaaRating() + DELIMITER;

     // Director Name
    dvdAsText += aDvd.getDirectorName() + DELIMITER;
    
     // studio
    dvdAsText += aDvd.getStudio() + DELIMITER;
    
     // User Rating
    dvdAsText += aDvd.getUserRating();
    
    // We have now turned a dvd to text! Return it!
    return dvdAsText;
    }
    
    /**
 * Writes all dvds in the library out to a LIBRARY_FILE.  See loadLibrary
 * for file format.
 * 
 * @throws DvdLibraryDaoException if an error occurs writing to the file
 */
    private void writeLibrary() throws DvdLibraryDaoException {
    // we are translating it to an application specific exception and 
    // then simple throwing it (i.e. 'reporting' it) to the code that
    // called us.  It is the responsibility of the calling code to 
    // handle any errors that occur.
        PrintWriter out;

    try {
        out = new PrintWriter(new FileWriter(LIBRARY_FILE));
    } catch (IOException e) {
        throw new DvdLibraryDaoException(
                "Could not save DVD data.", e);
    }

    // Write out the Dvd objects to the library file.
    String dvdAsText;
    List<Dvd> dvdList = this.getAllDvds();
        for (Dvd currentDvd : dvdList) {
        // turn a Dvd into a String
            dvdAsText = marshallDvd(currentDvd);
        // write the Dvd object to the file
            out.println(dvdAsText);
        // force PrintWriter to write line to the file
        out.flush();
    }
    // Clean up
    out.close();
    }

    private Dvd unmarshallDvd(String currentLine) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
