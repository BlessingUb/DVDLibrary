/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.ui;

import com.mthree.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author blessingubogu
 */
public class DvdLibraryView {
    private UserIO io = new UserIOConsoleImpl();
    
    public int printMenuAndGetSelection(){
        io.print("Main Menu");
        io.print("1. List all DVD");
        io.print("2. Create New DVD");
        io.print("3. Remove a DVD");
        io.print("4. Edit a DVD");
        io.print("5. Display DVD info");
        io.print("6. Exit");

        return io.readInt("Please select from the above choices.", 1, 6);
    }

    //  get information to create a new dvd in the collection
    public Dvd getNewDvdInfo() {
        String title = io.readString("Please enter Dvd title");
        String releaseDate = io.readString("Please enter the release date");
        String mpaaRating = io.readString("Please enter the MPAA Rating");
        String directorName = io.readString("Please enter the Director's Name");
        String studio = io.readString("Please enter the Studio");
        String userRating = io.readString("Please enter any additional info");
        
        
        Dvd currentDvd = new Dvd(title);
        currentDvd.setReleaseDate(releaseDate);
        currentDvd.setMpaaRating(mpaaRating);
        currentDvd.setDirectorName(directorName);
        currentDvd.setStudio(studio);
        currentDvd.setUserRating(userRating);
        return currentDvd;
    
    }
    
    public void displayDvdList(List<Dvd> dvdList) {
        for (Dvd currentDvd : dvdList) {
            String dvdInfo = String.format("%s || %s || %s || %s || %s || %s",
                currentDvd.getTitle(),
                currentDvd.getReleaseDate(),
                currentDvd.getMpaaRating(),
                currentDvd.getDirectorName(),
                currentDvd.getStudio(),
                currentDvd.getUserRating());
            io.print(dvdInfo);
        }
        io.readString("Hit enter to continue.");
    }
    
    // display banner for new dvd
    public void displayCreateDvdBanner() {
    io.print("=== Create new Dvd  ===");
    }
    
    // display message for new dvd created
    public void displayCreateSuccessBanner() {
    io.readString(
            "Dvd successfully created.  Hit enter to continue");
    }
    
    // display all dvds banner
    public void displayDisplayAllDvdBanner() {
        io.print("=== Display All DVDs ===");
    }
}
