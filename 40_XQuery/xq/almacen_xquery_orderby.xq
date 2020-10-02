(: ORDER BY :)
(:--------- :)

(:obtiene todos los productos ordenados por nombre.:)
for $pro in /almacen/categoria/productos/producto
order by $pro/nombreProducto
return $pro

(:ordenamos los artículos en orden de menor a mayor importe que podemos recaudar por sus ventas.:)
(:for $pro in /almacen/categoria/productos/producto
let $recaudacion := $pro/precio*$pro/stock
order by $recaudacion 
return $pro: :)