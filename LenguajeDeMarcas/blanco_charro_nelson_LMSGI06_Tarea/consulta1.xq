(:1. Nombre, fecha de nacimiento y fecha fallecimiento de todos los artistas.:)
for $x in doc("artistas.xml")/artistas/artista
return
  <artista>
    {$x/nombreCompleto, $x/nacimiento, $x/fallecimiento}
  </artista>
