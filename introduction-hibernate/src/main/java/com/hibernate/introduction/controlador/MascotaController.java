package com.hibernate.introduction.controlador;

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

  // ACCIONES

}
