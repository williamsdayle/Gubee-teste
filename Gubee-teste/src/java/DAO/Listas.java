package DAO;

import back_end.Gubee;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.RequestScoped;

import javax.inject.Named;


@Named
@RequestScoped
public class Listas{     
    private List<Gubee> gubees;
    Dados bd = new Dados();
    public Listas(){
    gubees = bd.returnListaGubees();
    
    }
    
    
    public List<Gubee> getGubees() {
        return gubees;
    }

    public void setGubees(List<Gubee> gubees) {
        this.gubees = gubees;
    }
   
 
    
 
    
}
