package com.hibernate.introduction.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Indicar que la clase Mascota representa una entidad en la BD
@Entity
// Indicar el nombre de la tabla en BD a la que representa la clase Mascota
@Table(name = "mascotas")
public class Mascota {

  // ATRIBUTOS
  @Id // Indica primary key
  private int id;
  // @Column(name="nombre")
  private String nombre;
  private String apellido;
  private String raza;
  private String foto;
  private String observacion;

  // CONSTRUCTORES

  public Mascota() {
  }

  public Mascota(String nombre, String apellido, String raza, String foto, String observacion) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.raza = raza;
    this.foto = foto;
    this.observacion = observacion;
  }

  @Override
  public String toString() {
    String info = "----------------------\n";
    info += "Nombre: " + nombre;
    info += "\nApellido: " + apellido;
    info += "\nRaza: " + raza;
    info += "\nFoto: " + foto;
    info += "\nObservación: " + observacion;
    info += "\n----------------------\n";
    return info;
  }

  // CONSULTORES // GETTERS
  public int getId() {
    return id;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public String getRaza() {
    return raza;
  }

  public String getFoto() {
    return foto;
  }

  public String getObservacion() {
    return observacion;
  }

  // MODIFICADORES // SETTERS
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public void setRaza(String raza) {
    this.raza = raza;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public void setObservacion(String observacion) {
    this.observacion = observacion;
  }

}
