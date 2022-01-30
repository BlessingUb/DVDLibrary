/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mthree.dvdlibrary.dto;

/**
 *
 * @author blessingubogu
 */
public class Dvd {
    // dvd attribuutes
    private String title;
    private localDate releaseDate;
    private String mpaaRating;
    private String directorName;
    private String studio;
    private String userRating;

    public Dvd(String Title) {
        this.title = title;
    }

  
    public localDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(localDate ReleaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMpaaRating() {
        return mpaaRating;
    }

    public void setMpaaRating(String mpaaRating) {
        this.mpaaRating = mpaaRating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

}
