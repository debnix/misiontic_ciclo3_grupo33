
// Referenciar el elemento div
const div = document.getElementById('app')
// adicionar texto
div.innerHTML = "<h2>Hola mundo desde js</h2>"

// Usuarios
const usuarios = [
  { nombre: "Milfer", apellido: "Muñoz" },
  { nombre: "Mateo", apellido: "Sepulveda" },
  { nombre: "Valeria", apellido: "Sanchez" },
  { nombre: "Andres", apellido: "Quintero" },
  { nombre: "Karol", apellido: "Cardenas" },
  { nombre: "Alejandra", apellido: "Muñoz" },
  { nombre: "Sara", apellido: "Quintana" }
]

// Referenciar tabla
const tabla = document.getElementById('tabla')
tabla.innerHTML += `<tbody>`
// Iterar usuarios
for (let i = 0; i < usuarios.length; i++) {
  tabla.innerHTML += `
  <tr>
      <td>${usuarios[i].nombre}</td>
      <td>${usuarios[i].apellido}</td>
  </tr>
  `
}
tabla.innerHTML += `</tbody>`

let msg = "Andres"
// template string
console.log(`Hola ${msg}`)