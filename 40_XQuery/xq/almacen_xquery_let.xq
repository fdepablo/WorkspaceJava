(: LET :)
(:-------:)
(:filtrar los resultados según el valor de una expresión calculada:)

(:Si multiplicamos para cada producto el stock por el precio, nos dará como resultado una cantidad que corresponde a lo que podríamos recaudar por la venta de todo el stock de dicho producto.:)

(:obtener los productos cuya recaudación posible sea mayor a 2.000 euros:)
for $pro in /almacen/categoria/productos/producto
let $recaudacion := $pro/precio * $pro/stock
where $recaudacion > 2000
return $pro

(:funciones de agregado. El siguiente ejemplo muestra el nombre de todas las categorías que cuentan con más de 10 artículos distintos.:)
(:for $cat in /almacen/categoria
let $c := count($cat/productos/producto)
where $c > 10
return $cat/nombreCategoria:)