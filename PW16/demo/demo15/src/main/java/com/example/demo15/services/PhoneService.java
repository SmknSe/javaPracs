package com.example.demo15.services;


import com.example.demo15.entities.Phone;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import com.example.demo15.entities.Manufacture;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.NoResultException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService implements TableService<Phone> {
    private final SessionFactory sessionFactory;
    private Session session;

    @PostConstruct
    public void init(){
        session = sessionFactory.openSession();
    }

    public Manufacture getManufactureByPhone(Long phoneId){
        Manufacture manufacture = session.createQuery("from Phone where id=:id",Phone.class).setParameter("id",phoneId).getSingleResult().getManufacture();
        return manufacture;
    }

    @Override
    public void createEntity(Phone phone) {
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(phone);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Phone> readAllEntity() {
        session = sessionFactory.openSession();
        List<Phone> phones = session.createQuery("select i from Phone i", Phone.class).getResultList();
        return phones;
    }

    @Override
    public Phone readOneEntity(long id) {
        Phone phone = null;
        try {
            phone = session.createQuery("from Phone where id = :id", Phone.class)
                    .setParameter("id", id).getSingleResult();
        }
        catch (NoResultException noResultException){

        }
        System.out.println(phone);
        return phone;
    }

    @Override
    public boolean updateEntity(Phone phone, long id) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Phone set name=:n, creationYear=:y where id = :id")
                .setParameter("id", id)
                .setParameter("n", phone.getName())
                .setParameter("y", phone.getCreationYear());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return true;
    }

    @Override
    public boolean deleteEntity(long id) {
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Phone where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        return true;
    }

    @PreDestroy
    public void destruct(){
        session.close();

    }

}
