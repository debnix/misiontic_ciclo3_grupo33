
async function get_mascotas (url) {
  // Enviar petición
  const resp = await fetch(url)
  const mascotas = await resp.json()
  return mascotas
}

function listar_mascotas (mascotas) {
  // Referenciar tabla
  const table = document.getElementById("table")
  let tbody = "<tbody>"
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
                  <button class="btn btn-warning">Actualizar</button>
                  <button class="btn btn-danger">Eliminar</button>
                </td>
              </tr>`
  }
  tbody += "</tbody>"
  table.innerHTML += tbody
}

async function main () {
  const url = "http://localhost:8080/mascotas";
  const mascotas = await get_mascotas(url)
  listar_mascotas(mascotas)
}

main()