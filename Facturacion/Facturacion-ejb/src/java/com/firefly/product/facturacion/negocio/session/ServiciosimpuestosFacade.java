/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.session;

import com.firefly.product.facturacion.negocio.entities.Serviciosimpuestos;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author dclav
 */
@Stateless
public class ServiciosimpuestosFacade extends AbstractFacade<Serviciosimpuestos> {

    @PersistenceContext(unitName = "Facturacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServiciosimpuestosFacade() {
        super(Serviciosimpuestos.class);
    }
    
    public List<Serviciosimpuestos> findAllImpuestosServicio(Serviciosimpuestos serviciosimpuestos) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Serviciosimpuestos> q = cb.createQuery(Serviciosimpuestos.class);
        Root<Serviciosimpuestos> c = q.from(Serviciosimpuestos.class);

        cq.where(cb.equal(c.get("idservicios"), serviciosimpuestos.getIdservicios()));
        
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
