/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.session;

import com.firefly.product.facturacion.negocio.entities.Usuariosroles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dclav
 */
@Stateless
public class UsuariosrolesFacade extends AbstractFacade<Usuariosroles> {

    @PersistenceContext(unitName = "Facturacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuariosrolesFacade() {
        super(Usuariosroles.class);
    }
    
}
