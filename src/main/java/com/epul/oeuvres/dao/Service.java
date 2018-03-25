package com.epul.oeuvres.dao;

import com.epul.oeuvres.meserreurs.MonException;
import java.util.*;

import com.epul.oeuvres.metier.*;

import javax.persistence.EntityTransaction;

public class Service extends EntityService{

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



 //Lister les adherents

/*	public List<AdherentEntity> consulterListeAdherents() throws MonException {
		List<AdherentEntity> mesAdherents = null;
		try
		{
			EntityTransaction transac = startTransaction();
			transac.begin();
			mesAdherents = (List<AdherentEntity>) entityManager.createQuery("SELECT a FROM AdherentEntity a ORDER BY a.nomAdherent").getResultList();
			entityManager.close();
		}
		catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mesAdherents;
	}

// Consultation d'une adherent par son numéro


	public AdherentEntity adherentById(int numero) throws MonException {
		List<AdherentEntity> adherents = null;
		AdherentEntity adherent = new AdherentEntity();
		try {
			EntityTransaction transac = startTransaction();
			transac.begin();

			adherents = (List<AdherentEntity>) entityManager.createQuery("SELECT a FROM AdherentEntity a WHERE a.idAdherent="+numero).getResultList();
			adherent = adherents.get(0);
			entityManager.close();
		}catch (RuntimeException e)
		{
			new MonException("Erreur de lecture", e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adherent;
	}*/



}
