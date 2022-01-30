/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.ui;

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

     
}
