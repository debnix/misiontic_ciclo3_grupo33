/**VARIABLES**/
const n1 = 10;
let n2 = 20;
n2 = 30;
var n3 = 40;
n3 = 50;

const suma = n1 + n2 + n3;
// mostrar mensajes en consola
console.log("Suma = " + suma);

/****ARREGLOS*****/
let numeros = [10, 20, 30, 40, 50, 60];
console.log(numeros);
// Añadir nuevo elemento
numeros.push(70);
numeros.push(80);
// Eliminar elementos
numeros.pop();
numeros.pop();

// Iterar array
for (let i = 0; i < numeros.length; i++) {
  console.log(numeros[i]);
}

// Objetos
let persona = {
  nombre: "Alejandra",
  apellido: "Hernandez",
  edad: 28,
  celular: "3123456789"

}
console.log(persona)
// Acceder a las claves del objeto
console.log(Object.keys(persona))
// Acceder a los valores del objeto
console.log(Object.values(persona))
// Acceder a los atributos del objeto
console.log(persona.nombre)
console.log(persona["apellido"])