/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.edo.atmlist.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edo Virgolim
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ATMRequest {
    
    private List<ATM> atmList;
    private ATM atmObj;

    public ATMRequest() {
        this.atmList = new ArrayList<ATM>();
        this.atmObj = new ATM();
    }

    public ATMRequest(List<ATM> atmList) {
        this.atmList = new ArrayList<ATM>();
        this.atmList = atmList;
    }
    
    public ATMRequest(ATM atmObj) {
        this.atmObj = new ATM();
        this.atmObj = atmObj;
    }

    public List<ATM> getAtmList() {
        return atmList;
    }

    public void setAtmList(List<ATM> atmList) {
        this.atmList = atmList;
    }
    
    public ATM getAtmObj() {
        return atmObj;
    }

    public void setAtmObj(ATM atmObj) {
        this.atmObj = atmObj;
    }
    
    
}
