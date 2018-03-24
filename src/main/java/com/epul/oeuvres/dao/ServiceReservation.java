package com.epul.oeuvres.dao;

import com.epul.oeuvres.metier.ReservationEntity;

import javax.persistence.EntityTransaction;
import java.util.List;

public class ServiceReservation extends EntityService {

    public void insertReservation(ReservationEntity reservation) {
        try {
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
            entityManager.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<ReservationEntity> getListReservation(){
        List<ReservationEntity> reservationList = null;
        try{
            EntityTransaction transaction = startTransaction();
            transaction.begin();
            reservationList = (List<ReservationEntity>) entityManager.createQuery("select r from ReservationEntity r order by r.dateReservation").getResultList();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return reservationList;
    }


}
