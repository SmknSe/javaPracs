package com.example.demo15.services;


import com.example.demo15.entities.Manufacture;
import com.example.demo15.entities.Phone;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ManufactureService implements TableService<Manufacture> {

    private final SessionFactory sessionFactory;
    private Session session;
    

    @Override
    public void createEntity(Manufacture manufacture) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(manufacture);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Manufacture> readAllEntity() {
        session = sessionFactory.openSession();
        List<Manufacture> manufactures = session.createQuery("select i from Manufacture i", Manufacture.class).getResultList();
        session.close();
        return manufactures;
    }

    @Override
    public Manufacture readOneEntity(long id) {
        session = sessionFactory.openSession();
        Manufacture manufacture = session.createQuery("from Manufacture where id = :id", Manufacture.class).setParameter("id", id).getSingleResult();
        session.close();
        return manufacture;
    }

    @Override
    public boolean updateEntity(Manufacture manufacture, long id) {
        session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query q = session.createQuery("update Manufacture set name=:n where id = :id")
                .setParameter("id", id)
                .setParameter("n", manufacture.getName());
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
        Query q = session.createQuery("delete from Manufacture where id = :id")
                .setParameter("id", id);
        int status = q.executeUpdate();
        System.out.println(status);
        transaction.commit();
        session.close();
        return true;
    }

    public List<Manufacture> sortManufacturesByName(){
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Manufacture> manufactureCriteriaQuery = builder.createQuery(Manufacture.class);
        Root<Manufacture> root = manufactureCriteriaQuery.from(Manufacture.class);
        manufactureCriteriaQuery.select(root).orderBy(builder.asc(root.get("name")));
        Query<Manufacture> query = session.createQuery(manufactureCriteriaQuery);
        return query.getResultList();
    }

    public List<Manufacture> filterManufacturesByName(String name){
        session = sessionFactory.openSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Manufacture> manufactureCriteriaQuery = builder.createQuery(Manufacture.class);
        Root<Manufacture> root = manufactureCriteriaQuery.from(Manufacture.class);
        manufactureCriteriaQuery.select(root).where(builder.equal(root.get("name"),name));
        Query<Manufacture> query = session.createQuery(manufactureCriteriaQuery);
        return query.getResultList();
    }

    @PreDestroy
    public void close(){
        session.close();
    }

}
