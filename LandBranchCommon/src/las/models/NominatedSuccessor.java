/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package las.models;

import java.io.Serializable;

/**
 *
 * @author Nuwantha
 */
public class NominatedSuccessor implements Serializable{
    private String NIC_S;
    private String name;
    private String address;

    public NominatedSuccessor(String NIC_S, String name, String address) {
        this.NIC_S = NIC_S;
        this.name = name;
        this.address = address;
    }
    
    
    public String getNIC_S() {
        return NIC_S;
    }

    public void setNIC_S(String NIC_S) {
        this.NIC_S = NIC_S;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
