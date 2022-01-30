/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary;

import com.mthree.dvdlibrary.controller.DvdLibraryController;
import com.mthree.dvdlibrary.dao.DvdLibraryDao;
import com.mthree.dvdlibrary.dao.DvdLibraryDaoFileImpl;
import com.mthree.dvdlibrary.ui.DvdLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author blessingubogu
 */
public class App {
    public static void main(String[] args) {
        UserIO myIo = new UserIOConsoleImpl();
        DvdLibraryView myView = new DvdLibraryView(myIo);
        DvdLibraryDao myDao = new DvdLibraryDaoFileImpl();
        DvdLibraryController controller =
                new DvdLibraryController(myDao, myView);
        controller.run();
//            DvdLibraryController controller = new DvdLibraryController();
//            controller.run();
        } 
}
