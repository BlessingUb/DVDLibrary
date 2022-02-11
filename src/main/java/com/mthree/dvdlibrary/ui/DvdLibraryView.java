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
    private UserIO io;
    
    // implement a constructor that initializes the io member field.
    public DvdLibraryView(UserIO io) {
        this.io = io;
    }
    
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

    // ability to delete unwanted dvd from the library
    public void displayDeleteResult(Dvd dvdRecord) {
        if(dvdRecord != null){
          io.print("Dvd successfully deleted.");
        }
        else
        {
          io.print("No such dvd found.");
        }
        io.readString("Hit enter to continue.");
    }
    
    // displays a dvd's information to the user
    public void displayDvd(Dvd dvd) {
        if (dvd != null) {
            io.print(dvd.getTitle());
            io.print(dvd.getReleaseDate());
            io.print(dvd.getMpaaRating());
            io.print(dvd.getDirectorName());
            io.print(dvd.getStudio());
            io.print(dvd.getUserRating());
            io.print("");
        } else {
            io.print("No such dvd is found.");
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
    
   
    // display message for deleting exosting dvd
    public void displayDeleteDvdBanner () {
    io.print("=== Remove Dvd ===");
}
// ask the user for dvd title they wish to display
    public String getTitleChoice() {
        return io.readString("Enter the dvd title:");
    }
    
    // display the dvd banner
    public void displayDisplayDvdBanner () {
        io.print("=== Display Dvd info ===");
    } 
    
    // new method to display exit 
    public void displayExitBanner() {
        io.print("Bye for now!!!");
    }

    public void displayInvalidCommandBanner() {
        io.print("Invalid Command!!!");
    }
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }

    public void displayEditReleaseDateBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditResult() {
        io.print("DVD Successfully edited.");
    } 
    
    public String getReleaseDate() {
        return io.readString("Enter the new DVD release date.");
    }

    public String getMpaaRating() {
        return io.readString("Enter the new DVD MPAA rating.");
    }

    public String getDirectorName() {
        return io.readString("Enter the new director's name.");
    }
    
    public String getStudioName() {
        return io.readString("Enter the studio name.");
    }
    
    public String getUserRating() {
        return io.readString("Enter the new user rating.");
    }

    public int printEditMenuAndGetSelection() {
        io.print("Which field do you want to change?");
        io.print("Edit DVD menu");
        io.print("1. Release date");
        io.print("2. MPAA rating");
        io.print("3. Director's name");
        io.print("4. User rating");
        io.print("5. Studio name");
        io.print("6. Exit edit menu");
        return io.readInt("Please select from the above choices.", 1,6);
    }

    public void displayNullDvd() {
        io.print("No such DVD");
    }

    public void displayEditDvdBanner() {
        io.print("=== Edit DVD Release Date ===");
    }

    public void displayEditMpaaRatingBanner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void displayEditDirectorNameBanner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void displayEditUserRatingBanner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void displayEditStudioBanner() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

