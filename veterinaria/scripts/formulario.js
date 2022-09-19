
function get_data_form (evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  const form = evt.target
  const mascota = {
    nombre: form.nombre.value,
    apellido: form.apellido.value,
    raza: form.raza.value,
    foto: form.foto.value,
    observacion: form.observacion.value
  }
  console.table({ mascota })
}