/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import datos.Persona;
import datos.TipoPersona;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import services.PersonaFacadeLocal;
import services.TipoPersonaFacadeLocal;

/**
 *
 * @author Ariel
 */
@Named(value = "bean")
@RequestScoped
public class PersonaBean {



    @EJB
    private TipoPersonaFacadeLocal tipoPersonaFacade;

    @EJB
    private PersonaFacadeLocal personaFacade;
    
    private String nombre;
    private int edad;
    private TipoPersona tipo;
    
    private Persona p = new Persona();
    
        public Persona getP() {
        return p;
    }

    public void setP(Persona p) {
        this.p = p;
    }
    
    public PersonaBean() {
        tipo= new TipoPersona();
    }
    
    public List<Persona> getPersona()
    {
        return personaFacade.findAll();
    }
    
     public List<TipoPersona> getTipoPersona()
    {
        return tipoPersonaFacade.findAll();
    }
     
     public void Buscar()
     {     
     }
       
    public String Crear()
    {
        Persona p = new Persona();               
        p.setNombre(nombre);
        p.setEdad(edad);       
        p.setIdtipoPersona(tipoPersonaFacade.find(tipo.getIdtipoPersona()));           
        personaFacade.create(p);
        return "index";
    }
    
    public String editar(Persona p)
    {
        this.p = p;
        return "editarPersona";
        
    }
    
    public String editar()
    {
        this.personaFacade.edit(this.p);
        return "index";
    }
    

    public TipoPersona getTipo() {
        return tipo;
    }

    public void setTipo(TipoPersona tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

  

    public TipoPersonaFacadeLocal getTipoPersonaFacade() {
        return tipoPersonaFacade;
    }

    public void setTipoPersonaFacade(TipoPersonaFacadeLocal tipoPersonaFacade) {
        this.tipoPersonaFacade = tipoPersonaFacade;
    }

    public PersonaFacadeLocal getPersonaFacade() {
        return personaFacade;
    }

    public void setPersonaFacade(PersonaFacadeLocal personaFacade) {
        this.personaFacade = personaFacade;
    }
    
    
            
            
    
}
