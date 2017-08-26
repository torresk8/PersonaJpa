/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ariel
 */
@Entity
@Table(name = "tipo_persona")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TipoPersona.findAll", query = "SELECT t FROM TipoPersona t")
    , @NamedQuery(name = "TipoPersona.findByIdtipoPersona", query = "SELECT t FROM TipoPersona t WHERE t.idtipoPersona = :idtipoPersona")
    , @NamedQuery(name = "TipoPersona.findByTipo", query = "SELECT t FROM TipoPersona t WHERE t.tipo = :tipo")})
public class TipoPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idtipo_persona")
    private Integer idtipoPersona;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo")
    private String tipo;
    @OneToMany(mappedBy = "idtipoPersona")
    private List<Persona> personaList;

    public TipoPersona() {
    }

    public TipoPersona(Integer idtipoPersona) {
        this.idtipoPersona = idtipoPersona;
    }

    public TipoPersona(Integer idtipoPersona, String tipo) {
        this.idtipoPersona = idtipoPersona;
        this.tipo = tipo;
    }

    public Integer getIdtipoPersona() {
        return idtipoPersona;
    }

    public void setIdtipoPersona(Integer idtipoPersona) {
        this.idtipoPersona = idtipoPersona;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public List<Persona> getPersonaList() {
        return personaList;
    }

    public void setPersonaList(List<Persona> personaList) {
        this.personaList = personaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipoPersona != null ? idtipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPersona)) {
            return false;
        }
        TipoPersona other = (TipoPersona) object;
        if ((this.idtipoPersona == null && other.idtipoPersona != null) || (this.idtipoPersona != null && !this.idtipoPersona.equals(other.idtipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datos.TipoPersona[ idtipoPersona=" + idtipoPersona + " ]";
    }
    
}
