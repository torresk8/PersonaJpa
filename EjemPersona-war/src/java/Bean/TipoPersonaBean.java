/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import datos.Persona;
import datos.TipoPersona;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import services.PersonaFacadeLocal;
import services.TipoPersonaFacadeLocal;

/**
 *
 * @author Ariel
 */
@Named(value = "tipoPersonaBean")
@RequestScoped
public class TipoPersonaBean {

    @EJB
    private TipoPersonaFacadeLocal tipoPersonaFacade;

    private int id;
    private String tipo;
    
    private TipoPersona t = new TipoPersona();

    public TipoPersona getT() {
        return t;
    }

    public void setT(TipoPersona t) {
        this.t = t;
    }
    
    
    

    public List<TipoPersona> getTipoPersona()
    {
        return tipoPersonaFacade.findAll();
    }
    public TipoPersonaBean() {
    }
    
    public String crear()
    {
        TipoPersona t = new TipoPersona();
        t.setTipo(tipo);
        tipoPersonaFacade.create(t);
        return "index";
    }
    
    public String editar(TipoPersona t)
    {
        this.t = t;
        return "editarTipoPersona";
        
    }
    
    public String editar()
    {
        this.tipoPersonaFacade.edit(this.t);
        return "index";
    }

    public TipoPersonaFacadeLocal getTipoPersonaFacade() {
        return tipoPersonaFacade;
    }

    public void setTipoPersonaFacade(TipoPersonaFacadeLocal tipoPersonaFacade) {
        this.tipoPersonaFacade = tipoPersonaFacade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
