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

  public String getNombreApellidoComun(String nombre, String apellido) {
    return "Nombre: " + nombre + " - Apellido: " + apellido;
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

}
