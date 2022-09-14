package com.hibernate.introduction.controlador;

import java.util.ArrayList;
import java.util.List;

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
import com.hibernate.introduction.servicios.MascotaService;

@RestController
@RequestMapping("/mascotas")
public class MascotaController {

  private MascotaService service;

  // CONSTRUCTOR
  public MascotaController() {
    service = new MascotaService();
  }

  /*
   * @GetMapping
   * public String getMascotas() {
   * return "Hola mundo utilizando Spring Boot";
   * }
   */

  @GetMapping
  public List<Mascota> getMascotas() {
    return service.getMascotas();
  }

  @GetMapping("/{raza}")
  public List<Mascota> getXRaza(@PathVariable(name = "raza") String raza) {
    return service.getXRaza(raza);
  }

  @GetMapping("/commons")
  public Mascota getNombreApellido(@RequestParam String nombre, @RequestParam String apellido) {
    return service.getNombreApellido(nombre, apellido);
  }

  @PostMapping
  public String create(@RequestBody Mascota mascota) {
    return service.create(mascota);
  }

}
