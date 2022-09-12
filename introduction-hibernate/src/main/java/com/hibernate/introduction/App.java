package com.hibernate.introduction;

import javax.swing.JOptionPane;

import com.hibernate.introduction.controlador.MascotaController;

public class App {
    public static void main(String[] args) {
        MascotaController controller = new MascotaController();
        String message = controller.create("Firulais", "Perez", "Criollo", "http://fake-photo", "No tiene vacunas");
        JOptionPane.showMessageDialog(null, message);
    }
}
