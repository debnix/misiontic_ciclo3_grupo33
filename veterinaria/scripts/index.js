const URL_API = "http://localhost:8080/mascotas";
let ID_MASCOTA = -1

async function get_mascotas (url) {
  // Enviar petición
  const resp = await fetch(url)
  const mascotas = await resp.json()
  return mascotas
}

function listar_mascotas (mascotas) {
  // Referenciar tabla
  const table = document.getElementById("tbody")
  let tbody = ""
  // Iterar mascotas
  for (let i = 0; i < mascotas.length; i++) {
    const m = mascotas[i]
    tbody += `<tr> 
                <td> 
                  <img src="${m.foto}"/>
                </td>
                <td>${m.nombre}</td>
                <td>${m.apellido}</td>
                <td>${m.raza}</td>
                <td>${m.observacion}</td>
                <td>
                  <button class="btn btn-warning" onclick='update(${JSON.stringify(m)})'>Actualizar</button>
                  <button class="btn btn-danger" onclick='btn_delete(${JSON.stringify(m)})' data-bs-toggle="modal" data-bs-target="#exampleModal">Eliminar</button>
                </td>
              </tr>`
  }
  table.innerHTML = tbody
}

function btn_delete (mascota) {
  document.getElementById("mascota-eliminar").innerText = mascota.nombre + " " + mascota.apellido
  ID_MASCOTA = mascota.id
}

async function delete_pet () {
  // enviar petición
  const resp = await fetch(`${URL_API}/${ID_MASCOTA}`, {
    method: 'DELETE'
  })
  const text = await resp.text()
  alert(text)
  main()
}

function update (mascota) {
  window.location.href = `formulario.html?mascota=${JSON.stringify(mascota)}`
}


function submit_search (evt) {
  evt.preventDefault()
  const nombre = evt.target.nombre_mascota.value
  console.log(nombre)
  search(nombre)

}

async function search (nombre) {
  // enviar petición
  const resp = await fetch(`${URL_API}/commons?nombre=${nombre}`)
  const mascota = await resp.json()
  listar_mascotas([mascota])
}


async function main () {
  const mascotas = await get_mascotas(URL_API)
  listar_mascotas(mascotas)
}

main()