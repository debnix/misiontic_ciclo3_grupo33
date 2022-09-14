
async function get_mascotas (url) {
  // Enviar petición
  const resp = await fetch(url)
  const mascotas = await resp.json()
  return mascotas
}

async function main () {
  const url = "http://localhost:8080/mascotas";
  const mascotas = await get_mascotas(url)
  console.log(mascotas)
}

main()