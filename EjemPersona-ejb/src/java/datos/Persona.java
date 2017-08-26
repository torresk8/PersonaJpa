/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p")
    , @NamedQuery(name = "Persona.findByIdPerosna", query = "SELECT p FROM Persona p WHERE p.idPerosna = :idPerosna")
    , @NamedQuery(name = "Persona.findByNombre", query = "SELECT p FROM Persona p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Persona.findByEdad", query = "SELECT p FROM Persona p WHERE p.edad = :edad")})
     
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPerosna")
    private Integer idPerosna;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "edad")
    private int edad;
    @JoinColumn(name = "idtipo_persona", referencedColumnName = "idtipo_persona")
    @ManyToOne
    private TipoPersona idtipoPersona;

    public Persona() {
    }

    public Persona(Integer idPerosna) {
        this.idPerosna = idPerosna;
    }

    public Persona(Integer idPerosna, String nombre, int edad) {
        this.idPerosna = idPerosna;
        this.nombre = nombre;
        this.edad = edad;
    }

    public Integer getIdPerosna() {
        return idPerosna;
    }

    public void setIdPerosna(Integer idPerosna) {
        this.idPerosna = idPerosna;
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

    public TipoPersona getIdtipoPersona() {
        return idtipoPersona;
    }

    public void setIdtipoPersona(TipoPersona idtipoPersona) {
        this.idtipoPersona = idtipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPerosna != null ? idPerosna.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.idPerosna == null && other.idPerosna != null) || (this.idPerosna != null && !this.idPerosna.equals(other.idPerosna))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.Persona[ idPerosna=" + idPerosna + " ]";
    }
    
}
