 XML
-----
Los documentos XML siguen un esquema jerárquico, compuesto por etiquetas con 
apertura y cierre que tienen la siguiente estructura: 
<etiqueta> contenido </etiqueta>. 
Cada etiqueta puede portar otras subetiquetas, formando así la jerarquía. 
Como primer ejemplo se puede ver el fichero "cruceros.xml" y podemosç
verlo con un navegador su estructura

 CSS
-----
Son estilos y formatos que se puden aplicar a XML o HTML
Para meter los estilos al fichero "cruceros.xml" debemos de poner
la siguiente linea:
<?xml-stylesheet type="text/css" href="cruceros.css" ?>
despues de 
<?xml version="1.0" encoding="UTF-8"?>

 TRANSFORMACIONES
------------------
1- XSLT (EXtensible Stylesheet Language Transformations): 
Permite convertir documentos XML a otros formatos (por ejemplo, HTML).
Una plantilla podría ser la siguiente (fichero con extensión xsl):

--------------------------------------------------------------------------------
<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- AQUÍ VA LA ESTRUCTURA DEL DOCUMENTO HTML -->
	</xsl:template>
</xsl:stylesheet>
--------------------------------------------------------------------------------
Para enlazar un fichero xsl con un fichero xml debemos de poner la 
siguiente linea en el FICHERO XML:
<?xml-stylesheet type="text/xsl" href="cruceros.xsl"?>
despues de la linea
<?xml version="1.0" encoding="UTF-8"?>

OJO!!! Probar en edge ya que por defecto Chrome tiene deshabilitado
el poder ver xml a traves de un xsl.
Para habilitarlo, habría que arrancar Chrome con el parametro 
"--allow-file-access-from-files"
Firefox tambien puede dar problemas

