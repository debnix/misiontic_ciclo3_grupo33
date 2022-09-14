package com.hibernate.introduction.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/id/{id}")
  public Mascota getMascotaXId(@PathVariable(name = "id") int id) {
    return service.getMascotaXId(id);
  }

  @PostMapping
  public String create(@RequestBody Mascota mascota) {
    return service.create(mascota);
  }

  @PutMapping
  public String update(@RequestBody Mascota mascota) {
    return service.update(mascota);
  }

  @DeleteMapping("/{id}")
  public String delete(@PathVariable(name = "id") int id) {
    return service.delete(id);
  }

}
