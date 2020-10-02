(: xquery trabaja con expresiones FLWOR (for, let, where, order y return :)

(: FOR :)
(:-----:)

(:mostrar todos los nombre de las categorías:)
for $cat in /almacen/categoria/nombreCategoria
return $cat

(:for $cat in //nombreCategoria
return $cat:)

(:vamos a seleccionar todos los nodos productos que quedarán almacenamos en la variable $pro.:)
(:for $pro in /almacen/categoria/productos/producto
return $pro:)

(:También podemos volver a utilizar XPath para seleccionar de nuevo elementos dentro del contenido de la variable $pro.:)
(:for $pro in /almacen/categoria/productos/producto
return $pro/nombreProducto:)


