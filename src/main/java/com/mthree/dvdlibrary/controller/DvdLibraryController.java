/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DvdLibraryDao;
import com.mthree.dvdlibrary.dao.DvdLibraryDaoException;
import com.mthree.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthree.dvdlibrary.dto.Dvd;
import com.mthree.dvdlibrary.ui.DvdLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;
import java.util.List;

/**
 *
 * @author blessingubogu
 */
public class DvdLibraryController {
//    private DvdLibraryView view = new DvdLibraryView();
//    private UserIO io = new UserIOConsoleImpl();
//    private DvdLibraryDao dao = new DvdLibraryDaoFileImpl();
    
/* a constructor in the controller that has a DvdLibraryDao
    parameter and a DvdLibraryView parameter and uses the 
    incoming values to initialize the DvdLibraryDao 
    and DvdLibraryView member fields
    
    */
    
    private DvdLibraryView view;
    private DvdLibraryDao dao;
    
    public DvdLibraryController(DvdLibraryDao dao, DvdLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            while (keepGoing) {
                menuSelection = getMenuSelection();
            
                switch (menuSelection) {
                    case 1:
                        listDvds();
                        break;
                    case 2:
                        createDvd();
                        break;
                    case 3:
                        deleteDvd();
                        break;
                   case 4:
                        editDvd();
                        break;
                    case 5:
                        viewDvdInfo();
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        invalidCommand();
                }

            }
            exitMessage();
        } catch (DvdLibraryDaoException e) {
        view.displayErrorMessage(e.getMessage());
        }
    }
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }

    private void createDvd() throws DvdLibraryDaoException{
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.createDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    
    private void listDvds() throws DvdLibraryDaoException{
        view.displayDisplayAllDvdBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    
    // private methiod to delete the dvd and capture the returned dvd
    private void deleteDvd() throws DvdLibraryDaoException{
        view.displayDeleteDvdBanner();
        String title = view.getTitleChoice();
        Dvd deletedDvd = dao.deleteDvd(title);
        view.displayDeleteResult(deletedDvd);
    }
    
    
    //private method asks the view to display the View Dvd banner and get 
    //the title from the user
    private void viewDvdInfo() throws DvdLibraryDaoException{
        view.displayDisplayDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvd = dao.getDvd(title);
        view.displayDvd(dvd);
    }
    
    // private methods for the view to display the right message to the user
    private void invalidCommand() {
        view.displayInvalidCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }
    
    private void editDvd() throws DvdLibraryDaoException  {
        view.displayEditDvdBanner();
        String title = view.getTitleChoice();
        Dvd dvdToEdit = dao.getDvd(title);
        if (dvdToEdit==null) {
            view.displayNullDvd();
        } else {
            view.displayDvd(dvdToEdit);
            int editMenuSelection = 0;
            boolean keepGoing = true;
            while (keepGoing) {
                editMenuSelection = view.printEditMenuAndGetSelection();

                switch (editMenuSelection){
                    case 1:
                        editReleaseDate(title);
                        break;
                    case 2:
                        editMpaaRating(title);
                        break;
                    case 3:
                        editDirectorName(title);
                        break;
                    case 4:
                        editStudioName(title);
                        break;
                    case 5:
                        editUserRating(title);
                        break;
                    case 6:
                        keepGoing = false;
                        break;
                    default:
                        invalidCommand();
                }
                if (keepGoing == false) {
                    break;
            } 
        }
        }
    }


    private void editReleaseDate(String title) throws DvdLibraryDaoException {
        view.displayEditReleaseDateBanner();
        String newReleaseDate = view.getReleaseDate();
        Dvd editedDvd = dao.changeReleaseDate(title, newReleaseDate);
        view.displayEditResult();
    }
    private void editMpaaRating(String title) throws DvdLibraryDaoException {
        //view.displayEditMpaaRatingBanner();
        String newMpaaRating = view.getMpaaRating();
        Dvd editedDvd = dao.changeMpaaRating(title, newMpaaRating);
        view.displayEditResult();
    }
    private void editDirectorName(String title) throws DvdLibraryDaoException {
        //view.displayEditDirectorNameBanner();
        String newDirectorName = view.getDirectorName();
        Dvd editedDvd = dao.changeDirectorName(title, newDirectorName);
        view.displayEditResult();
    }
    private void editUserRating(String title) throws DvdLibraryDaoException {
        String newUserRating = view.getUserRating();
        Dvd editedDvd = dao.changeUserRating(title, newUserRating);
        view.displayEditResult();
    }
    private void editStudioName(String title) throws DvdLibraryDaoException {
        String newStudioName = view.getStudioName();
        Dvd editedDvd = dao.changeStudioName(title, newStudioName);
        view.displayEditResult();
    }
}
