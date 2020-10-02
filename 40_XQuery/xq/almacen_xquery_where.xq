(: WHERE :)
(:-------:)

(:seleccionar aquellos productos cuyo precio sea superior a 30 euros.:)
for $pro in /almacen/categoria/productos/producto
where $pro/precio > 30
return $pro

(:obtener los productos cuyo precio esté en un rango entre
 30 y 40 euros.:)
(:for $pro in /almacen/categoria/productos/producto
where $pro/precio >= 30 and $pro/precio <= 40
return $pro:)

(:productos de la categoria bebidas:)
(:for $cat in /almacen/categoria
where $cat/nombreCategoria = "Bebidas"
return $cat/productos/producto:)

(:obtener todos los artículos de las categorías bebidas o condimentos.:)
(:for $cat in /almacen/categoria
where $cat/nombreCategoria = "Bebidas" or $cat/nombreCategoria = "Condimentos"
return $cat/productos/producto:)

(:, mostraremos todos los artículos que no sean ni bebidas ni condimentos.:)
(:for $cat in /almacen/categoria
where not($cat/nombreCategoria = "Bebidas" or $cat/nombreCategoria = "Condimentos")
return $cat/productos/producto:)