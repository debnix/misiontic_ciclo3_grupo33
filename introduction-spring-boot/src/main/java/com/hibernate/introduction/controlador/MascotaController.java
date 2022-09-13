package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.List;

import javax.websocket.server.PathParam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.introduction.modelo.Mascota;

@RestController
@RequestMapping("/mascotas")
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

  /*
   * @GetMapping
   * public String getMascotas() {
   * return "Hola mundo utilizando Spring Boot";
   * }
   */

  @GetMapping
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

  @GetMapping("/{raza}")
  public List<Mascota> getXRaza(@PathVariable(name = "raza") String raza) {
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

  @GetMapping("/commons")
  public String getNombreApellidoComun(@RequestParam String nombre, @RequestParam String apellido) {
    return "Nombre: " + nombre + " - Apellido: " + apellido;
  }

  @PostMapping
  public String create(@RequestBody Mascota mascota) {
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
