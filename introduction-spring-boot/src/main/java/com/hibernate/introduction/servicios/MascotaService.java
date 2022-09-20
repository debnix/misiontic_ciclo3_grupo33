package com.hibernate.introduction.servicios;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Mascota;

public class MascotaService {

  // ATRIBUTOS
  private SessionFactory factory;

  public MascotaService() {
    // Crear objeto que permita fabricar sesiones
    factory = new Configuration()
        .configure("cfg.xml")
        .addAnnotatedClass(Mascota.class)
        .buildSessionFactory();
  }

  public Session openSession() {
    Session session = factory.openSession();
    session.beginTransaction();
    return session;
  }

  public List<Mascota> getMascotas() {
    List<Mascota> mascotas = new ArrayList<>();
    Session session = openSession();
    try {
      mascotas = session.createQuery("from Mascota", Mascota.class).list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mascotas;
  }

  public List<Mascota> getXRaza(String raza) {
    List<Mascota> mascotas = new ArrayList<>();
    Session session = openSession();
    try {
      mascotas = session.createQuery("from Mascota where raza = :param_raza", Mascota.class)
          .setParameter("param_raza", raza)
          .list();
      session.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mascotas;
  }

  public Mascota getMascotaXId(int id) {
    Mascota mascota = new Mascota();
    Session session = openSession();
    try {
      mascota = session.find(Mascota.class, id);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return mascota;
  }

  public Mascota getNombreApellido(String nombre) {
    Mascota mascota = new Mascota();
    Session session = openSession();
    try {
      List<Mascota> list = session
          .createQuery("from Mascota where nombre = :nombre", Mascota.class)
          .setParameter("nombre", nombre)
          .list();
      if (list.size() > 0) {
        mascota = list.get(0);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    session.close();
    return mascota;
  }

  public String create(Mascota mascota) {
    String resp = "";
    Session session = openSession();
    try {
      session.persist(mascota);
      session.getTransaction().commit();
      resp = "Mascota creada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      resp = e.getMessage();
    }
    session.close();
    return resp;
  }

  public String update(Mascota mascota) {
    String message = "";
    Session session = openSession();
    try {
      session.merge(mascota);
      session.getTransaction().commit();
      message = "Mascota actualizada con exito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

  public String delete(int id) {
    String message = "";
    Session session = openSession();
    try {
      Mascota mascota = getMascotaXId(id);
      session.remove(mascota);
      session.getTransaction().commit();
      message = "Mascota eliminada con éxito";
    } catch (Exception e) {
      e.printStackTrace();
      message = e.getMessage();
    }
    session.close();
    return message;
  }

}
