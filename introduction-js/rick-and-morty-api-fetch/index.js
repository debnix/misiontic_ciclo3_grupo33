
async function obtener_personajes (url_api) {
  // Realizar petición de tipo get
  const resp = await fetch(url_api, {
    method: 'GET' //, 'POST', 'PUT', 'DELETE'
  })
  // Obtener datos de la petición
  const data = await resp.json()
  return data.results
}


function mostrar_personajes (personajes) {
  let cards = ''
  for (let i = 0; i < personajes.length; i++) {
    cards += `
      <article class="card">
				<img src="https://rickandmortyapi.com/api/character/avatar/1.jpeg" />
				<div class="body-card">
					<h3>Rick Sanchez</h3>
					<span>Status: Alive</span>
					<span>Specie: Human</span>
					<span>Gender: Male</span>
					<span>Origin: Earth</span>
				</div>
			</article>
    `
  }
  // Adicionar targetas al section
  document.getElementById('section-cards').innerHTML = cards
}


function main () {
  const url = 'https://rickandmortyapi.com/api/character'
  obtener_personajes(url)
}

main()