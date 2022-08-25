<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
  <html>
  <head>
    <meta charset="UTF-8"/>
    <title>Tabla de artistas</title>
  </head>
  <body>
    <h2>Tabla de artistas</h2>
    <table >
      <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Año de nacimiento</th>
        <th>Movimiento</th>
        <th>Género</th>
        <th>País</th>
        <th>Página web</th>
      </tr>
      <xsl:for-each select="artistas/artista">
      <xsl:sort select="nombreCompleto"/>
      <xsl:if test="./pais='España'">
      <tr>
        <td><xsl:value-of select="./@cod"/></td>
        <td><xsl:value-of select="nombreCompleto"/></td>
        <td><xsl:value-of select="nacimiento"/></td>
        <td><xsl:value-of select="movimiento"/></td>
        <td>Varios</td>
        <td><xsl:value-of select="pais"/></td>
        <td>
          <a target="blank" href="{fichaCompleta}">Saber más</a>
        </td>
      </tr>
      </xsl:if>
      </xsl:for-each>
    </table>
  </body>
  </html>
</xsl:template>

</xsl:stylesheet>

