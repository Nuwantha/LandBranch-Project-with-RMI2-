/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.controller;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import las.models.Lot;

/**
 *
 * @author DinsuG
 */
public interface LotController extends Remote {

    public boolean addNewLot(Lot lot) throws RemoteException, SQLException,ClassNotFoundException;

    public Lot searchLot(String lotNumber) throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<Lot> searchLotOfLand(String planNumber) throws RemoteException, SQLException,ClassNotFoundException;

    public ArrayList<Lot> getAvailableLotOfLand(String planNumber) throws RemoteException, SQLException,ClassNotFoundException;

    public boolean updateLot(Lot lot) throws RemoteException, SQLException,ClassNotFoundException;

    public Lot getLastAddedLot() throws RemoteException, SQLException,ClassNotFoundException;
}
