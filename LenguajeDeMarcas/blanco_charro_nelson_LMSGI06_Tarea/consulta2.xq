(:2. El nombre (sin etiquetas) de los artistas que nacieron después de 1500.:)

(:Opcion 1. Donde aparece sin etiquetas el nombreCompleto pero si tiene etiquetas el return.:)
for $x in doc("artistas.xml")/artistas/artista
where $x/number(nacimiento) > 1500
return 
  <nombre>
    {data($x/nombreCompleto)}
  </nombre>

(:Opcion 2. Donde no aparecen etiquetas ni en el nombreCompleto ni en el return.:)
for $x in doc("artistas.xml")/artistas/artista
where $x/number(nacimiento) > 1500
return $x/nombreCompleto/text()
