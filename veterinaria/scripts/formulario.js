
function get_data_form (evt) {
  // Indicar que no recarge página al enviar el formulario
  evt.preventDefault()
  let nombre = evt.target.nombre.value;
  console.table({ nombre })
}