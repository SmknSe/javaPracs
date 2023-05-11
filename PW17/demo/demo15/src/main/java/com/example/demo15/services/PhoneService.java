package com.example.demo15.services;


import com.example.demo15.entities.Phone;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;
import com.example.demo15.entities.Manufacture;

import javax.annotation.PreDestroy;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService implements TableService<Phone> {
    private final SessionFactory sessionFactory;
    private Session session;

    public Manufacture getManufactureByPhone(Long phoneId){
        session = sessionFactory.openSession();
        Manufacture manufacture = session.createQuery("from Phone where id=:id",Phone.class).setParameter("id",phoneId).getSingleResult().getManufacture();
        session.close();
        return manufacture;
    }

    @Override
    public void createEntity(Phone phone) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(phone);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Phone> readAllEntity() {
        session = sessionFactory.openSession();
        List<Phone> phones = session.createQuery("select i from Phone i", Phone.class).getResultList();
        session.close();
        return phones;
    }

    @Override
    public Phone readOneEntity(long id) {
        session = sessionFactory.openSession();
        Phone phone = null;
        try {
            phone = session.createQuery("from Phone where id = :id", Phone.class)
                    .setParameter("id", id).getSingleResult();
        }
        catch (NoResultException noResultException){

        }
        System.out.println(phone);
        session.close();
        return phone;
    }

    @Override
    public boolean updateEntity(Phone phone, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Phone set name=:n, creationYear=:y where id = :id")
                .setParameter("id", id)
                .setParameter("n", phone.getName())
                .setParameter("y", phone.getCreationYear());
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteEntity(long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("delete from Phone where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    public List<Phone> sortPhonesByName(){
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> phoneCriteriaQuery = builder.createQuery(Phone.class);
        Root<Phone> root = phoneCriteriaQuery.from(Phone.class);
        phoneCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Phone> query = session.createQuery(phoneCriteriaQuery);
        return query.getResultList();
    }

    public List<Phone> filterPhonesByName(String name){
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Phone> phoneCriteriaQuery = builder.createQuery(Phone.class);
        Root<Phone> root = phoneCriteriaQuery.from(Phone.class);
        phoneCriteriaQuery.select(root).where(builder.equal(root.get("name"),name));
        Query<Phone> query = session.createQuery(phoneCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void close(){
        session.close();
    }

}
