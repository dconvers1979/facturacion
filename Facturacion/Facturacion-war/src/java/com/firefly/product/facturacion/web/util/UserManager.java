/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.web.util;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author dclav
 */
@ManagedBean
@SessionScoped
public class UserManager {
    
    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        
        return "/index.xhtml?faces-redirect=true";
    }
    
}
