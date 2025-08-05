package com.HDemo;


import jakarta.persistence.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
//             Alien a=new Alien();
//             a.setAid(5);
//             a.setName("Vamsi");
//             a.setTech("JFS");


//        Configuration configuration=new Configuration();
//        configuration.addAnnotatedClass(com.HDemo.Alien.class);
//        configuration.configure();//"hibernate.cfg.xml"

        SessionFactory factory=new Configuration()
                .addAnnotatedClass(com.HDemo.Alien.class)
                .configure().buildSessionFactory();
        Session session= (Session) factory.openSession();

//       Transaction transaction=session.beginTransaction();--this create teh data
//         session.persist(a);--this create teh data


        //-- fetching the data
      //  Alien a=session.get(Alien.class,3);//eager
       // Alien a=session.find(Alien.class,3);//newer version
       // Alien a=session.byId(Alien.class).load(103);
       // Alien a=session.byId(Alien.class).getReference(3);--this is lazy fetching data
     // transaction.commit();--this commit the data
       // System.out.println(a);



        //update the data
//               Transaction transaction=session.beginTransaction();//--this update the data
//                session.merge(a);
//                transaction.commit();

                //Delete the data
        Transaction transaction=session.beginTransaction();
        Alien a=session.find(Alien.class,5);
        session.remove(a);
        transaction.commit();

        session.close();
      factory.close();
        }


}
