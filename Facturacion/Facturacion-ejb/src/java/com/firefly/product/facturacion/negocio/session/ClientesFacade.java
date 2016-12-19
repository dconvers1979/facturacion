/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.session;

import com.firefly.product.facturacion.negocio.entities.Clientes;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

/**
 *
 * @author dclav
 */
@Stateless
public class ClientesFacade extends AbstractFacade<Clientes> {

    @PersistenceContext(unitName = "Facturacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientesFacade() {
        super(Clientes.class);
    }

    public List<Clientes> findAllPersons() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Clientes> q = cb.createQuery(Clientes.class);
        Root<Clientes> c = q.from(Clientes.class);

        cq.where(cb.equal(c.get("tipoCliente"), 1));
        
        return getEntityManager().createQuery(cq).getResultList();
    }

}
