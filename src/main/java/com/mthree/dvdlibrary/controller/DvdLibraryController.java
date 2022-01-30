/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.dao.DvdLibraryDao;
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
    }
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
    
    private void createDvd() {
        view.displayCreateDvdBanner();
        Dvd newDvd = view.getNewDvdInfo();
        dao.createDvd(newDvd.getTitle(), newDvd);
        view.displayCreateSuccessBanner();
    }
    
    private void listDvds() {
        view.displayDisplayAllDvdBanner();
        List<Dvd> dvdList = dao.getAllDvds();
        view.displayDvdList(dvdList);
    }
    
    // private methiod to delete the dvd and capture the returned dvd
    private void deleteDvd() {
        view.displayDeleteDvdBanner();
        String title = view.getTitleChoice();
        Dvd deletedDvd = dao.deleteDvd(title);
        view.displayDeleteResult(deletedDvd);
    }
    
    
    //private method asks the view to display the View Dvd banner and get 
    //the title from the user
    private void viewDvdInfo() {
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
}
