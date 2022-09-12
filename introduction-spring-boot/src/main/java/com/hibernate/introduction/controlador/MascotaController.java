package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Mascota;

public class MascotaController {

  // ATRIBUTOS
  private SessionFactory factory;

  // CONSTRUCTOR
  public MascotaController() {
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

  // ACCIONES
  public String create(String nombre, String apellido, String raza, String foto, String observacion) {
    String resp = "";
    Session session = openSession();
    try {
      Mascota mascota = new Mascota(nombre, apellido, raza, foto, observacion);
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

}
