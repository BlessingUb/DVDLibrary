/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.controller;

import com.mthree.dvdlibrary.ui.UserIO;
import com.mthree.dvdlibrary.ui.UserIOConsoleImpl;

/**
 *
 * @author blessingubogu
 */
public class DvdLibraryController {
    private UserIO io = new UserIOConsoleImpl();

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {
            io.print("Main Menu");
            io.print("1. List all DVD");
            io.print("2. Create New DVD");
            io.print("3. Remove a DVD");
            io.print("4. Edit a DVD");
            io.print("5. Display DVD info");
            io.print("6. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices.", 1, 6);

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
    
}
