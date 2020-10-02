(:Insertamos:)

insert node 
<categoria id="9">
  <nombreCategoria>Legumbres</nombreCategoria>
  <productos>
    <producto>
      <nombreProducto>Garbanzos del Bierzo</nombreProducto>
      <cantidadPorUnidad>Paquete de un kg</cantidadPorUnidad>
      <precio>20.16</precio>
      <stock>39</stock>
    </producto>
   </productos>
 </categoria>
 after /almacen/categoria[8]
 
 (: o así :)
 (:insert node 
    <producto>
      <nombreProducto>Judiones del Bierzo</nombreProducto>
      <cantidadPorUnidad>Paquete de un kg</cantidadPorUnidad>
      <precio>18.16</precio>
      <stock>12</stock>
    </producto>
 after /almacen/categoria[last()]/productos/producto[last()]:)
 
(: modificar :)
(:Esta sentencia asigna el valor 3 al precio del último producto de la última categoría. :)
(:replace value of node /almacen/categoria[last()]/productos/producto[last()]/precio with 3 :)


(: borrado :)
(:delete node /almacen/categoria[last()]:)