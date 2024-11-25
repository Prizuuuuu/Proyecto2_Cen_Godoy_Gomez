const json = require("../Baratheon.json");

function transformarEstructura(original) {
  const resultado = {};

  // Recorrer cada casa en la estructura original
  for (const [casa, personajes] of Object.entries(original)) {
    resultado[casa] = {}; // Crear un objeto para cada casa

    // Recorrer los personajes de la casa
    personajes.forEach((personaje) => {
      const [nombre, detalles] = Object.entries(personaje)[0];

      // Transformar los detalles del personaje
      const nuevoPersonaje = {
        name_number: null,
        parents: [],
        aliases: [],
        title: null,
        spouse: null,
        physical: { eyes: null, hair: null },
        children: [],
        notes: null,
        fate: null,
      };

      // Recorrer las claves de los detalles para asignarlas al nuevo formato
      detalles.forEach((detalle) => {
        const [clave, valor] = Object.entries(detalle)[0];

        switch (clave) {
          case "Of his name":
            nuevoPersonaje.name_number = valor;
            break;
          case "Born to":
            nuevoPersonaje.parents.push(valor);
            break;
          case "Known throughout as":
            nuevoPersonaje.aliases.push(valor);
            break;
          case "Held title":
            nuevoPersonaje.title = valor;
            break;
          case "Wed to":
            nuevoPersonaje.spouse = valor;
            break;
          case "Of eyes":
            nuevoPersonaje.physical.eyes = valor;
            break;
          case "Of hair":
            nuevoPersonaje.physical.hair = valor;
            break;
          case "Father to":
            nuevoPersonaje.children = valor;
            break;
          case "Notes":
            nuevoPersonaje.notes = valor;
            break;
          case "Fate":
            nuevoPersonaje.fate = valor;
            break;
        }
      });

      // Añadir el personaje transformado al resultado
      resultado[casa][nombre] = nuevoPersonaje;
    });
  }

  return resultado;
}

let raiz;

const procesarJson = () => {
  const jsonTransformado = transformarEstructura(json);
  console.log(jsonTransformado);
  const casas = Object.keys(json);
  for (casa of casas) {
    const personas = json[casa];
    for (persona of personas) {
      const nombre = Object.keys(persona)[0];

      const informacion = persona[nombre];

      // "Of his name",
      // "Born to",
      // "Born to",
      // "Known throughout as",
      // "Held title",
      // "Wed to",
      // "Of eyes",
      // "Of hair",
      // "Father to",
      // "Notes",
      // "Fate",

      const nombreNormalizado = nombre.replace(/\s+/g, " ").trim();
      console.log(nombreNormalizado);
    }
  }
};

procesarJson();
