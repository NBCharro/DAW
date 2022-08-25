(:9. Marca y modelo de las impresoras con tamaño A5 como único tamaño.:)
for $x in doc("impresoras.xml")/impresoras/impresora
where 
    $x/tamaño = "A5"
  and
    count($x/tamaño) <= 1
return 
  <impresora>
    <marca>
      {$x/marca/text()}
    </marca>
    <modelo>
      {$x/modelo/text()}
    </modelo>
  </impresora>
