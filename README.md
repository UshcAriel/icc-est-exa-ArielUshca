## Explicacion del metodo A
Use el comparator para ordenar segun los criterios sobreescribiendo el metodo para que ordene las categorias que queria siendo estas (workload) y (ProjectCode) descendente y ascendente

Luego utilize un TreeSet para eliminar duplicados  y la condicion (projects == null) en caso las lista sea nula retorne filter y no nos salte un error 

Por ultimo utilice un for para recorrer la lista y ver elemento por elemento cual cumplia el (minimunWorkload) para ser agregado en el filter

## Metodo classifyAndExtractProjects

En este metodo utilize un HashMap porque nos permite utilizar (Clave, valor) para ordenar la lista una forma de clasificar segun lo pedido

Luego utilize un for para recorrer la lista y categorizarla segun los criterios
