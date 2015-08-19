/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Gimhani
 */
public class Land  implements Serializable{
    private String planNumber;
    private String landName;
    private String divisionNumber;
    private String westBound;
    private String eastBound;
    private String northBound;
    private String southBound;
    private int NumberOfLot;
    private ArrayList<Lot> lotList;

    public Land(String planNumber, String landName, String divisionNumber, String westBound, String eastBound, String northBound, String southBound, int NumberOfLot) {
        this.planNumber = planNumber;
        this.landName = landName;
        this.divisionNumber = divisionNumber;
        this.westBound = westBound;
        this.eastBound = eastBound;
        this.northBound = northBound;
        this.southBound = southBound;
        this.NumberOfLot = NumberOfLot;
    }
    
     public Land(String planNumber, String landName, String divisionNumber, String westBound, String eastBound, String northBound, String southBound) {
        this.planNumber = planNumber;
        this.landName = landName;
        this.divisionNumber = divisionNumber;
        this.westBound = westBound;
        this.eastBound = eastBound;
        this.northBound = northBound;
        this.southBound = southBound;
     }
    
    public Land(String planNumber, String landName, String divisionNumber, String westBound, String eastBound, String northBound, String southBound, ArrayList<Lot> lotList) {
        this.planNumber = planNumber;
        this.landName = landName;
        this.divisionNumber = divisionNumber;
        this.westBound = westBound;
        this.eastBound = eastBound;
        this.northBound = northBound;
        this.southBound = southBound;
        this.lotList=lotList;
    } 
    
    

    public String getPlanNumber() {
        return planNumber;
    }

    public void setPlanNumber(String planNumber) {
        this.planNumber = planNumber;
    }

    public String getLandName() {
        return landName;
    }

    public void setLandName(String landName) {
        this.landName = landName;
    }

    public String getDivisionNumber() {
        return divisionNumber;
    }

    public void setDivisionNumber(String divisionNumber) {
        this.divisionNumber = divisionNumber;
    }

    public String getWestBound() {
        return westBound;
    }

    public void setWestBound(String westBound) {
        this.westBound = westBound;
    }

    public String getSouthBound() {
        return southBound;
    }

    public void setSouthBound(String southBound) {
        this.southBound = southBound;
    }

    public String getEastBound() {
        return eastBound;
    }

    public void setEastBound(String eastBound) {
        this.eastBound = eastBound;
    }

    public String getNorthBound() {
        return northBound;
    }

    public void setNorthBound(String northBound) {
        this.northBound = northBound;
    }

    public int getNumberOfLot() {
        return NumberOfLot;
    }

    public void setNumberOfLot(int NumberOfLot) {
        this.NumberOfLot = NumberOfLot;
    }

    public ArrayList<Lot> getLotList() {
        return lotList;
    }

    public void setLotList(ArrayList<Lot> lotList) {
        this.lotList = lotList;
    }
    
    
}
