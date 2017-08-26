/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import datos.TipoPersona;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ariel
 */
@Local
public interface TipoPersonaFacadeLocal {

    void create(TipoPersona tipoPersona);

    void edit(TipoPersona tipoPersona);

    void remove(TipoPersona tipoPersona);

    TipoPersona find(Object id);

    List<TipoPersona> findAll();

    List<TipoPersona> findRange(int[] range);

    int count();
    
}
