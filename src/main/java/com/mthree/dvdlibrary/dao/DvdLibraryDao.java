/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.Dvd;
import java.util.List;

/**
 *
 * @author blessingubogu
 */
public interface DvdLibraryDao {
    /**
     * Adds the given DVD to the Library and associates it with the given
     * dvd title. If there is already a dvd associated with the given
     * title it will return that dvd object, otherwise it will
     * return null.
     *
     * @param title  with which dvd is to be associated
     * @param dvd dvd to be added to the library
     * @return the Dvd object previously associated with the given  
     * dvd title if it exist, null otherwise
     */
    
    Dvd createDvd(String title, Dvd dvd)
      throws DvdLibraryDaoException;
    
    /**
     * Returns a List of all dvds in the Library.
     *
     * @return List containing all dvds in the library.
     */
    List<Dvd> getAllDvds()
     throws DvdLibraryDaoException;
    
    
    /**
     * Returns the dvd object associated with the given dvd title.
     * Returns null if no such dvd exists
     *
     * @param dvd title title of the dvd to retrieve
     * @return the Dvd object associated with the given dvd title,  
     * null if no such dvd exists
     */
    Dvd getDvd(String title)
       throws DvdLibraryDaoException;

    /**
     * Deletes from the Library the dvd associated with the given id.
     * Returns the dvd object that is being deleted or null if
     * there is no dvd associated with the given id
     *
     * @param title title of dvd to be deleted
     * @return Dvd object that was deleted or null if no dvd
     * was associated with the given dvd title
     */
    Dvd deleteDvd(String title)
      throws DvdLibraryDaoException;
    
    /**
     * Edits the DVD release date from the library the DVD associated 
     * with the given title.Returns the DVD object that is being edited 
     * or null if there is no DVD
     *  associated with the given title.
     * @param title title of DVD to be edited
     * @param releaseDate release date of DVD to be changed to
     * @return Dvd object that was edited or null if no DVD was associated with the 
     * given DVD title
     * @throws com.chloe.dvdlibrary.dao.DvdLibraryDaoException
     */
    
    Dvd changeReleaseDate(String title, String releaseDate)
      throws DvdLibraryDaoException;


    Dvd changeMpaaRating(String title, String mpaaRating)
      throws DvdLibraryDaoException;

   
    Dvd changeDirectorName(String title, String directorName)
      throws DvdLibraryDaoException;

    
    Dvd changeStudioName(String title, String studioName)
      throws DvdLibraryDaoException;
     
     
    Dvd changeUserRating(String title, String userRating)
      throws DvdLibraryDaoException;

   
       

}
