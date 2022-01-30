/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.dao;

import com.mthree.dvdlibrary.dto.Dvd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author blessingubogu
 */
public class DvdLibraryDaoFileImpl implements DvdLibraryDao{
    
    private Map<String, Dvd> dvds = new HashMap<>();

    @Override
    public Dvd createDvd(String title, Dvd dvd) {
        Dvd prevDvd = dvds.put(title, dvd);
        return prevDvd;
    }

    @Override
    public List<Dvd> getAllDvds() {
        return new ArrayList<Dvd>(dvds.values());
    }

    @Override
    public Dvd getDvd(String title) {
        return dvds.get(title);
    }

    @Override
    public Dvd deleteDvd(String title) {
        Dvd deletedDvd = dvds.remove(title);
        return deletedDvd;
    }
    
    // able to edit an exisiting dvd
//    @Override
//    public Dvd editDvd(String title) {
//        Dvd editedDvd = dvds.put(title);
//        return editedDvd;
//    }
//    
}
