/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import datos.TipoPersona;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ariel
 */
@Stateless
public class TipoPersonaFacade extends AbstractFacade<TipoPersona> implements TipoPersonaFacadeLocal {

    @PersistenceContext(unitName = "EjemPersona-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPersonaFacade() {
        super(TipoPersona.class);
    }
    
}
