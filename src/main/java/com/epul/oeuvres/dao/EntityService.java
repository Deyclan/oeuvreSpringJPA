package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.AdherentEntity;

import javax.persistence.*;

/**
 * Created by Valentin on 06/04/2016.
 */
public abstract class EntityService {

    protected EntityManager entityManager;
    protected EntityManagerFactory emf;

    public EntityTransaction startTransaction() throws Exception {
        emf = Persistence.createEntityManagerFactory("oeuvresjpa");
        entityManager = emf.createEntityManager();

        return entityManager.getTransaction();
    }
}