const URL_API = "http://localhost:8080/mascotas"

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
  create(mascota)
}


async function create (mascota) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(mascota)
  })
  const text = await resp.text()
  alert(text)
}