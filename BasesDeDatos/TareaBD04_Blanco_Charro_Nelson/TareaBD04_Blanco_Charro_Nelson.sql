-- ALUMNO: NELSON BLANCO CHARRO

-- EJERCICIO 1:
--Versión 1: Para cada cliente: Nombre del cliente, población y nº de ventas realizadas (cada registro de la tabla A_VENTAS es una venta). Ordenado por nombre del cliente.
SELECT
    C.NOMBRECLI "Nombre cliente",
    C.POBLACION "Poblacion",
    COUNT(V.IDVENTA) "Numero ventas"
FROM A_CLIENTES C, A_VENTAS V
WHERE V.NIF=C.NIF
GROUP BY C.NOMBRECLI, C.POBLACION
ORDER BY C.NOMBRECLI
;
-- Versión 2: en la que solo se visualicen los clientes de la provincia de CIUDAD REAL que hayan realizado mas de 3 ventas.
SELECT
    C.NOMBRECLI "Nombre cliente",
    C.POBLACION "Poblacion",
    COUNT(V.IDVENTA) "Numero ventas"
FROM A_CLIENTES C, A_VENTAS V
WHERE V.NIF=C.NIF
AND UPPER(C.PROVINCIA)='CIUDAD REAL'
GROUP BY C.NOMBRECLI, C.POBLACION
HAVING COUNT(V.IDVENTA)>3
ORDER BY C.NOMBRECLI
;

-- EJERCICIO 2:
-- De cada cliente: los siguientes datos de las ventas realizadas: NOMBRE DEL CLIENTE, NIF, FECHA DE LA VENTA, NOMBRE DEL ARTÍCULO, PRECIO VENTA(A_ARTICULOS), PRECIO VENTA (V_VENTA), UNIDADES VENDIDAS, TOTAL VENTA (PRECIO VENTA*UNIDADES VENDIDAS)
--Solo visualizaremos las ventas de los clientes de la provincia de Ciudad Real y Toledo.
--El nombre de los artículos debe llevar un 1 en cualquier lugar.
--La fecha de la venta esté entre 01/03/2019 y el 31/12/2020
--La fecha de la venta tendrá el siguiente formato: 13/JUNIO/2020
--Se ordenará por el nombre del cliente
--Versión 1:
SELECT
    C.NOMBRECLI "Nombre cliente",
    C.NIF,
    TO_CHAR(V.FECHA_VENTA, 'DD/MONTH/YYYY') "Fecha venta",
    A.NOMBREART "Nombre articulo",
    A.PRECIO_VENTA "Precio venta",
    V.PRECIO_VENTA "Precio vendido",
    V.UNIDADES_VENDIDAS "Unidades vendidas",
    V.PRECIO_VENTA*V.UNIDADES_VENDIDAS "Total"
FROM A_CLIENTES C, A_VENTAS V, A_ARTICULOS A
WHERE C.NIF=V.NIF AND V.IDARTICULO=A.IDARTICULO
AND UPPER(C.PROVINCIA) IN ('CIUDAD REAL', 'TOLEDO')
AND V.FECHA_VENTA BETWEEN '01/03/2019' AND '31/12/2020'
AND A.NOMBREART LIKE '%1%'
ORDER BY C.NOMBRECLI
;
--Versión 2:
SELECT
    C.NOMBRECLI "Nombre cliente",
    C.NIF,
    TO_CHAR(V.FECHA_VENTA, 'DD/MONTH/YYYY') "Fecha venta",
    A.NOMBREART "Nombre articulo",
    A.PRECIO_VENTA "Precio venta",
    V.PRECIO_VENTA "Precio vendido",
    V.UNIDADES_VENDIDAS "Unidades vendidas",
    V.PRECIO_VENTA*V.UNIDADES_VENDIDAS "Total"
FROM A_CLIENTES C INNER JOIN A_VENTAS V ON C.NIF=V.NIF INNER JOIN A_ARTICULOS A ON V.IDARTICULO=A.IDARTICULO
WHERE UPPER(C.PROVINCIA) IN ('CIUDAD REAL', 'TOLEDO')
AND V.FECHA_VENTA BETWEEN '01/03/2019' AND '31/12/2020'
AND A.NOMBREART LIKE '%1%'
ORDER BY C.NOMBRECLI
;

-- EJERCICIO 3:
-- Realiza una nueva versión del ejercicio anterior en la que sólo se tengan en cuenta los artículos que hayan comprado en total mas de 80 unidades.
SELECT
    C.NOMBRECLI "Nombre cliente",
    C.NIF,
    TO_CHAR(V.FECHA_VENTA, 'DD/MONTH/YYYY') "Fecha venta",
    A.NOMBREART "Nombre articulo",
    A.PRECIO_VENTA "Precio venta",
    V.PRECIO_VENTA "Precio vendido",
    V.UNIDADES_VENDIDAS "Unidades vendidas",
    V.PRECIO_VENTA*V.UNIDADES_VENDIDAS "Total"
FROM A_CLIENTES C, A_VENTAS V, A_ARTICULOS A
WHERE C.NIF=V.NIF AND V.IDARTICULO=A.IDARTICULO
AND UPPER(C.PROVINCIA) IN ('CIUDAD REAL', 'TOLEDO')
AND V.FECHA_VENTA BETWEEN '01/03/2019' AND '31/12/2020'
AND A.NOMBREART LIKE '%1%'
AND V.UNIDADES_VENDIDAS > 80
ORDER BY C.NOMBRECLI
;

-- EJERCICIO 4:
-- De cada fabricante: las ventas realizadas en el año 2019 de artículos que pertenezcan a la categoría CATEGORÍA 1, los datos a visualiza serán: 
-- Nombre del fabricante, Nombre de los artículos que ha vendido y por cada artículo la suma de las unidades vendidas y el total de las ventas de ese artículo (multiplicando las unidades vendidas por precio de venta de la tabla ventas).
-- Ordenado por nombre de fabricante y dentro de éste por nombre artículo
SELECT 
    F.NOMBREFAB "Nombre fabricante", 
    A.NOMBREART "Nombre articulo",
    SUM(V.UNIDADES_VENDIDAS) "Unidades vendidas", 
    SUM(V.UNIDADES_VENDIDAS*V.PRECIO_VENTA) "Total ventas"
FROM A_FABRICANTES F, A_VENTAS V, A_ARTICULOS A
WHERE V.FECHA_VENTA BETWEEN '01/01/2019' AND '31/12/2019'
AND A.IDCATEGORIA = '1'
AND F.IDFABRICANTE=A.IDFABRICANTE AND A.IDARTICULO=V.IDARTICULO
GROUP BY F.NOMBREFAB, A.NOMBREART
ORDER BY F.NOMBREFAB, A.NOMBREART
;

-- EJERCICIO 5:
-- Será parecido al anterior, se visualizará de cada fabricante, las ventas realizadas en el año 2019 de artículos que pertenezcan las categorías que tengan mas de 3 artículos.
-- Datos a visualizar: Nombre del fabricante, Nombre de los artículos que ha vendido, Nombre de la categoría y por cada artículo la suma de las unidades vendidas y el total de las ventas de ese artículo (multiplicando las unidades vendidas por precio de venta de la tabla ventas).
SELECT 
    F.NOMBREFAB "Nombre fabricante", 
    A.NOMBREART "Nombre articulo",
    C.NOMBRECATEG "Nombre categoria",
    SUM(V.UNIDADES_VENDIDAS) "Unidades vendidas", 
    SUM(V.UNIDADES_VENDIDAS*V.PRECIO_VENTA) "Total ventas"
FROM A_FABRICANTES F, A_VENTAS V, A_ARTICULOS A, A_CATEGORIAS C
WHERE V.FECHA_VENTA BETWEEN '01/01/2019' AND '31/12/2019'
AND F.IDFABRICANTE=A.IDFABRICANTE AND A.IDARTICULO=V.IDARTICULO AND C.IDCATEGORIA=A.IDCATEGORIA
GROUP BY F.NOMBREFAB, A.NOMBREART, C.NOMBRECATEG
HAVING SUM(A.IDCATEGORIA)<=3
ORDER BY F.NOMBREFAB, A.NOMBREART
;

-- EJERCICIO 6:
-- Realiza una versión del ejercicio anterior en la que solo se visualicen aquellos artículos cuya media de las unidades vendidas por ese fabricante sea mayor que la media de las unidades vendidas de todos los artículos
SELECT 
    F.NOMBREFAB "Nombre fabricante", 
    A.NOMBREART "Nombre articulo",
    C.NOMBRECATEG "Nombre categoria",
    SUM(V.UNIDADES_VENDIDAS) "Unidades vendidas", 
    SUM(V.UNIDADES_VENDIDAS*V.PRECIO_VENTA) "Total ventas"
FROM A_FABRICANTES F, A_VENTAS V, A_ARTICULOS A, A_CATEGORIAS C
WHERE V.FECHA_VENTA BETWEEN '01/01/2019' AND '31/12/2019'
AND F.IDFABRICANTE=A.IDFABRICANTE AND A.IDARTICULO=V.IDARTICULO AND C.IDCATEGORIA=A.IDCATEGORIA
GROUP BY F.NOMBREFAB, A.NOMBREART, C.NOMBRECATEG
HAVING SUM(A.IDCATEGORIA)<=3
AND AVG(V.UNIDADES_VENDIDAS) > (SELECT AVG(unidades_vendidas) FROM a_ventas)
ORDER BY F.NOMBREFAB, A.NOMBREART
;

-- EJERCICIO 7:
-- Se quiere visualizar de cada tienda, los siguientes datos de todos los pedidos realizados:
-- Nombre de la tienda, email, nombre artículo, nombre del fabricante, fecha pedido, unidades pedidas, precio unitario, total del pedido (unidades pedidas* precio unitario)
-- Se visualizarán los pedidos realizados en el año 2020, de los fabricantes FABRICANTE 1, FABRICANTE 2 Y FABRICANTE 5.
-- Ordenado por nombre de la tienda y nombre del artículo.
SELECT 
    T.NOMBRETIEN "Nombre tienda", 
    T.EMAIL "Correo electr.", 
    A.NOMBREART "Nombre articulo", 
    F.NOMBREFAB "Nombre fabricante", 
    P.FECHAPEDIDO "Fecha pedido", 
    P.UNIDADES_PEDIDAS "Unidades pedidas", 
    P.PRECIO_UNITARIO "Precio unitario", 
    SUM(P.UNIDADES_PEDIDAS*P.PRECIO_UNITARIO) "Total"
FROM A_TIENDAS T, A_ARTICULOS A, A_FABRICANTES F, A_PEDIDOS P
WHERE P.FECHAPEDIDO BETWEEN '01/01/2020' AND '21/12/2020'
AND F.NOMBREFAB IN ('FABRICANTE 1', 'FABRICANTE 2', 'FABRICANTE 5')
AND T.CIF=P.CIF AND P.IDARTICULO=A.IDARTICULO AND A.IDFABRICANTE=F.IDFABRICANTE
GROUP BY T.NOMBRETIEN, T.EMAIL, A.NOMBREART, F.NOMBREFAB, P.FECHAPEDIDO, P.UNIDADES_PEDIDAS, P.PRECIO_UNITARIO
ORDER BY T.NOMBRETIEN, A.NOMBREART
;

-- EJERCICIO 8:
-- Realiza una nueva versión del ejercicio anterior, en la que cambiaremos la condición de los fabricantes y sólo se tengan en cuenta los fabricantes que hayan realizado mas de 5 pedidos.
SELECT 
    T.NOMBRETIEN "Nombre tienda", 
    T.EMAIL "Correo electr.", 
    A.NOMBREART "Nombre articulo", 
    F.NOMBREFAB "Nombre fabricante", 
    P.FECHAPEDIDO "Fecha pedido", 
    P.UNIDADES_PEDIDAS "Unidades pedidas", 
    P.PRECIO_UNITARIO "Precio unitario", 
    SUM(P.UNIDADES_PEDIDAS*P.PRECIO_UNITARIO) "Total"
FROM A_TIENDAS T, A_ARTICULOS A, A_FABRICANTES F, A_PEDIDOS P
WHERE P.FECHAPEDIDO BETWEEN '01/01/2020' AND '21/12/2020'
AND A.IDFABRICANTE IN (SELECT A.IDFABRICANTE
FROM A_ARTICULOS A
GROUP BY A.IDFABRICANTE
HAVING COUNT(A.IDFABRICANTE)>=5)
AND T.CIF=P.CIF AND P.IDARTICULO=A.IDARTICULO AND A.IDFABRICANTE=F.IDFABRICANTE
GROUP BY T.NOMBRETIEN, T.EMAIL, A.NOMBREART, F.NOMBREFAB, P.FECHAPEDIDO, P.UNIDADES_PEDIDAS, P.PRECIO_UNITARIO
ORDER BY T.NOMBRETIEN, A.NOMBREART
;

-- EJERCICIO 9:
-- Visualizar el CIF, el nombre de la tienda y el total facturado de la tienda que haya realizado la mayor venta . Para saber cuál es la mayor venta, por cada tienda hay que sumar todos los totales de sus pedidos (unidades pedidas * precio unitario)
SELECT 
    P.CIF, 
    T.NOMBRETIEN "Nombre tienda", 
    SUM(P.UNIDADES_PEDIDAS*P.PRECIO_UNITARIO) "Total"
FROM A_TIENDAS T, A_PEDIDOS P
WHERE P.CIF=T.CIF
GROUP BY P.CIF, T.NOMBRETIEN
HAVING SUM(P.UNIDADES_PEDIDAS*P.PRECIO_UNITARIO)=(SELECT MAX(SUM(P.UNIDADES_PEDIDAS*P.PRECIO_UNITARIO))
FROM A_PEDIDOS P
GROUP BY P.CIF)
;
