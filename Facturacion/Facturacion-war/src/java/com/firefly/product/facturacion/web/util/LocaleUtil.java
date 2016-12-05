/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.firefly.product.facturacion.web.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author dclav
 */
@ManagedBean
@SessionScoped
public class LocaleUtil {
    
    private Collection countryList = new ArrayList();
    
    public LocaleUtil(){
        String []countries = Locale.getISOCountries();
        
        for (String countryCode : countries) {
            Locale obj = new Locale("", countryCode);
            
            LocaleVO localeVO = new LocaleVO();
            localeVO.setCode(obj.getCountry());
            localeVO.setName(obj.getDisplayCountry());
            countryList.add(localeVO);
        }
    }
    
    public Collection<LocaleVO> getCountryList(){
        return countryList;
    }
    
}
