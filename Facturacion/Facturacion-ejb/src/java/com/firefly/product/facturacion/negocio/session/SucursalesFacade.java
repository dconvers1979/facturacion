/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.negocio.session;

import com.firefly.product.facturacion.negocio.entities.Sucursales;
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
public class SucursalesFacade extends AbstractFacade<Sucursales> {

    @PersistenceContext(unitName = "Facturacion-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SucursalesFacade() {
        super(Sucursales.class);
    }
    
    public List<Sucursales> findAllSucursalesServices() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Sucursales> q = cb.createQuery(Sucursales.class);
        Root<Sucursales> c = q.from(Sucursales.class);

        cq.where(cb.equal(c.get("manejaServicios"), 1));
        
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    public List<Sucursales> findAllSucursalesProducts() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Sucursales> q = cb.createQuery(Sucursales.class);
        Root<Sucursales> c = q.from(Sucursales.class);

        cq.where(cb.equal(c.get("manejaInventario"), 1));
        
        return getEntityManager().createQuery(cq).getResultList();
    }
    
}
