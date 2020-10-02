<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<!-- 
		Para usar este XSL debemos de poner la siguiente sentencia
		en el XML
		<?xml-stylesheet type="text/xsl" href="cruceros.xsl"?>
		
		XSL es un motor para mostrar XML del formato que queramos.
		
		XSL se basa en plantillas (templates). Dentro de la etiqueta
		template podemos escribir como queremos que sea la salida del xml
		en este caso queremos mostrar un HTML, pero podria ser cualquier formato
		(texto plano, otro xml, csv, etc).
		El atributo "match" establece en que parte del XML nos queremos
		situar. Dentro iría lenguaje XPATH, que sirve para filtrar.
		En este primer ejemplo nos situamos en el nodo raiz "/"
 	-->
	<xsl:template match="/">
		<html>
		<head>
		<title>Cruceros</title>
		<!-- Tambien podriamos meter un css al html -->
		<link rel="stylesheet" href="css/estilo.css" />
		</head>
		<body>
		<!-- 
		For-each : 
			Esto representa una estructura de control repetitiva que se ejecuta para 
			cada elemento crucero dentro de otro elemento cruceros. 
			En cada repetición se establece un filtro de modo (select), 
			que delimita el contenido XML al elemento crucero que toque en 
			cada iteración. Tambien es XPATH
			Si la ruta empieza sin "/" estamos accediendo al nodo de manera
			relativa a donde nos encontremos, si ponemos "/" sería de manera
			absoluta
		 -->
		<xsl:for-each select="cruceros/crucero">
			<p>
			<!-- Con esta etiqueta seleccionamos el valor del nodo que queramos -->
				Destino: <xsl:value-of select="destino"/>
				<br />
				CIA: <xsl:value-of select="detalles/cia"/>
				<br />
				Dias: <xsl:value-of select="detalles/dias"/>
				<br />
				Fecha salida: <xsl:value-of select="detalles/fechaSalida"/>
			</p>
			<table>
				<tr>
				<th>Dia</th>
				<th>Parada</th>
				<th>Llegada</th>
				<th>Salida</th>
				</tr>
				<xsl:for-each select="escalas/escala">
					<tr>
					<!-- Con arroba accedemos a atributos -->
					<td><xsl:value-of select="@dia"/></td>
					<td><xsl:value-of select="parada"/></td>
					<td><xsl:value-of select="llegada"/></td>
					<td><xsl:value-of select="salida"/></td>
					</tr>
				</xsl:for-each>
			</table>
		</xsl:for-each>
		</body>
		</html>
		
	</xsl:template>
</xsl:stylesheet>