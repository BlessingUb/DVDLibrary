/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.ui.DvdLibraryView;
import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author blessingubogu
 */
public class DvdLibraryController {
    private DvdLibraryView view = new DvdLibraryView();
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            menuSelection = getMenuSelection();
            
            switch (menuSelection) {
                case 1:
                    io.print("LIST ALL DVDs");
                    break;
                case 2:
                    io.print("CREATE DVD");
                    break;
                case 3:
                    io.print("REMOVE DVD");
                    break;
                case 4:
                    io.print("EDIT DVD");
                    break;
                case 5:
                    io.print("DISPLAY DVD INFO");
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                    io.print("INVALID COMMAND!!!");
            }

        }
        io.print("BYE FOR NOW!!");
    }
    private int getMenuSelection(){
        return view.printMenuAndGetSelection();
    }
}
