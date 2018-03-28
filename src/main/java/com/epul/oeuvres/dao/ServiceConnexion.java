package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import java.util.*;

import com.epul.oeuvres.metier.*;

import javax.persistence.EntityTransaction;

public class ServiceConnexion extends EntityService{

/* Connexion selon user et password*/

    public boolean seConnecter(String user, String password){
        Map mParams = new HashMap();
        Map mParam;
        List<Object> rs;
        Boolean canLogin = false;

        try {
            if (user != null && password != null) {
                EntityTransaction transac = startTransaction();
                transac.begin();
                rs = entityManager.createQuery("SELECT a FROM AdherentEntity a WHERE a.nomAdherent='"+user+"' AND a.prenomAdherent='"+password+"'").getResultList();
                if (rs.size() > 0) {
                    canLogin = true;
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return canLogin;
    }

}
