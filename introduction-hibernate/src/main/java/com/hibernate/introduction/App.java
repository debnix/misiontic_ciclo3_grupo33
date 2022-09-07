package com.hibernate.introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.introduction.modelo.Mascota;

public class App {
    public static void main(String[] args) {
        // Crear objeto que permita fabricar sesiones
        SessionFactory factory = new Configuration()
                .configure("cfg.xml")
                .addAnnotatedClass(Mascota.class)
                .buildSessionFactory();

        // Abrir sessión
        Session session = factory.openSession();

        // Preparar la sesión para crear transacciones
        session.beginTransaction();
        try {
            /**** Crear objeto *****/
            // Mascota mascota = new Mascota("Roko", "Jimenez", "Criollo",
            // "http://fake-photo", "Ninguna");
            // session.persist(mascota);
            // session.getTransaction().commit();

            /***** Buscar entidad/registro/mascota ********/
            Mascota mascota = session.find(Mascota.class, 1);
            System.out.println("Mascota-> " + mascota.getNombre() + " Raza: " + mascota.getRaza());
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Cerrar sesión
        session.close();
    }
}
