const URL_API = "http://localhost:8080/mascotas"

const UPDATE_FLAG = {
  update: false,
  id: null
}

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
  if (UPDATE_FLAG.update) {
    // añade el id al objeto mascota
    mascota.id = UPDATE_FLAG.id
    update(mascota)
  } else {
    create(mascota)
  }

  clear(form)
}

function clear (form) {
  form.nombre.value = ""
  form.apellido.value = ""
  form.raza.value = ""
  form.foto.value = ""
  form.observacion.value = ""
}

async function update (mascota) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'PUT',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(mascota)
  })
  const text = await resp.text()
  alert(text)
  window.location.href = "index.html"
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

function get_params_url () {
  const params = window.location.search
  if (params) {
    const url = new URLSearchParams(params)
    const mascota = JSON.parse(url.get("mascota"))
    set_value_form(mascota)
    document.getElementById("btn-registrar").innerText = "Actualizar"
    UPDATE_FLAG.update = true
    UPDATE_FLAG.id = mascota.id
    document.getElementById("href-registrar").innerText = "Actualizar mascota"
  }

}

function set_value_form (mascota) {
  document.getElementById("nombre").setAttribute("value", mascota.nombre)
  document.getElementById("apellido").setAttribute("value", mascota.apellido)
  document.getElementById("raza").setAttribute("value", mascota.raza)
  document.getElementById("foto").setAttribute("value", mascota.foto)
  document.getElementById("observacion").innerText = mascota.observacion
}

get_params_url()