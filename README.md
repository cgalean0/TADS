
# Tipos abstractos de datos (TADS)

Este repositorio contiene implementaciones de tipos abstractos de datos como por ejemplo:
`Lista enlazadas` , `Lista con Arreglos`, `Pilas (Con listas enlazadas y lista con Arreglos)`




## Métodos de listas enlazadas y lista de arreglos.

Este TAD contiene métodos como:
- `Insertar al Inicio`
- `Insertar al Final`
- `Insertar en alguna posición`
- `Eliminar un elemento`
- `Eliminar elemento en alguna posicion`
- `Buscar elemento en la lista`
- `Obtener un elemento por indice`
- `Imprimir la lista`


## Métodos de las pilas (LIFO)

Las pilas funcionan en base a las dos clases anteriormente mencionadas.
Estas cuentan con métodos como:
- `Apilar`
- `Desapilar`
- `Ver el elemento en el tope`
- `Ver si la pila es vacía`
- `Vaciar la pila`
- `Imprimir la pila`
## TADS cola (FIFO)
Esta implementacion se ve mejor con un ejemplo como el de la cola de un banco, el primero en llegar será el primero en salir, estas funcionalidades las encontamos en las clases `ColaEnlazada`,`ColaArreglo`,`ColaCircular`.

Si bien `ColaArreglo` y `ColaEnlazada` son implementaciones buenas, la de mejor eficiencia es la `ColaCircular` ya que para insertar elementos manejamos solo indices y no hay necesidad de mover los elementos de lugar como en las demás colas.

### Algunos métodos de las colas son:
- `Encolar`
- `Desencolar`
- `Vaciar`
- `esVacia`
## Funcionalidades como verificar paréntesis
Con las clases desarrolladas en este repositorio aplicamos una nueva clase que verifica si en una expresión del tipo `"(4 + 3) * 15"` o `") 4 + 3 ( * 15"`, los paréntesis se encuentran bien balanceados, es decir que cada paréntesis de apertura tiene su cierre y está en la posicion correcta.

Una secuencia con:
```
 (4 + 3) * 15 => //retorna que está bien balanceado.
```
En cambio una secuencia con:
```
) 4 + 3 ( * 15 => //retorna que no está bien balanceado.
) 4 + (3 * 15) => //retorna que no está bien balanceado.
```
### ¿Que clases contienen estas implementaciones?
Estas son:
- `SecuenciaChars`
    - Esta está implementada en base a una libreria llamada Stack y está en el paquete `java.util`.
- `SecuenciaCharsArreglo`
    - Esta está implementada en base a la clase llamada `PilaListaArreglo`.
- `SecuenciaCharsEnlazada`
    - Esta está implementada en base a la clase llamada `PilaListaEnlazada`
## Como usar estas implementaciones
Lo primero es clonar este repositorio en nuestra maquina a través de la terminal con:
```
git clone <url-del-repo>
```
Una vez clonado el repositorio acceder al directorio TADS y dentro de el se encontraran todos los archivos de las clases.

Luego se puede importar cada una de estas implementaciones y empezar a utilizarlas.

```
Este repositorio se actualiza constantemente en medida de lo posible.
```