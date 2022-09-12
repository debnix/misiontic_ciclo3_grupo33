package com.hibernate.introduction;

import java.util.List;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controlador.MascotaController;
import com.hibernate.introduction.modelo.Mascota;

public class App {
    public static void main(String[] args) {
        MascotaController controller = new MascotaController();
        // String message = controller.create("Firulais", "Perez", "Criollo",
        // "http://fake-photo", "No tiene vacunas");
        // JOptionPane.showMessageDialog(null, message);
        List<Mascota> mascotas = controller.getXRaza("Bulldog");
        for (int i = 0; i < mascotas.size(); i++) {
            System.out.println(mascotas.get(i));
        }
    }
}
