/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package back_end;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author willi
 */
public class Gubee implements Serializable {

    private String productName;
    private String description;
    private List targetMarket;
    private List stack;

    @Override
    public String toString() {
        return "Gubee{" + "productName=" + productName + ", description=" + description + ", targetMarket=" + targetMarket + ", stack=" + stack + '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List getTargetMarket() {
        return targetMarket;
    }

    public void setTargetMarket(List targetMarket) {
        this.targetMarket = targetMarket;
    }

    public List getStack() {
        return stack;
    }

    public void setStack(List stack) {
        this.stack = stack;
    }

    
    
   

    
    
    
}
