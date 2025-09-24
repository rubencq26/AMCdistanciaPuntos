# Práctica 1: Algoritmos Exhaustivos, con Poda y Divide y Vencerás

**Algorítmica y Modelos de Computación**  
3º Grado Ingeniería Informática  
Curso 2024-25

---

## Objetivo
El objetivo de la práctica 1 es desarrollar algoritmos para resolver un problema clásico de búsqueda sobre conjuntos de puntos: **la búsqueda del punto más cercano a otro**.  
Se plantearán las siguientes estrategias:
- Búsqueda exhaustiva
- Búsqueda con poda
- Divide y Vencerás
- Divide y Vencerás con mejora

---

## El Problema del punto más cercano
Dado un conjunto de puntos situados en un plano:

P = { (x1,y1), (x2,y2), …, (xn,yn) }


Se debe encontrar el par de puntos `(xi, yi)` y `(xj, yj)` cuya **distancia euclídea** sea mínima:

dist((xi, yi), (xj, yj)) = sqrt[(xi-xj)^2 + (yi-yj)^2]


---

## Estrategias de resolución

### 1. Búsqueda Exhaustiva
- Analizar todos los pares de puntos.
- Complejidad: **O(n²)**.
- Simple y rápido para pequeños conjuntos, pero ineficiente para grandes volúmenes de datos.

### 2. Búsqueda con Poda
- Ordenar los puntos según la coordenada `x` o `y`.
- Se descartan comparaciones innecesarias cuando la diferencia entre coordenadas ya supera la mínima distancia encontrada.
- Complejidad: **O(n log n)** (por la ordenación).

### 3. Divide y Vencerás
- Dividir el conjunto en dos mitades.
- Calcular la distancia mínima en cada lado y en la zona central.
- Complejidad: **O(n log n)**.

### 4. Divide y Vencerás Mejorado
- Ordenar los puntos de la franja central por coordenada `y`.
- Solo se comparan como máximo 11 puntos consecutivos.
- Complejidad: **O(n log n)**, incluso en casos degenerados.

---

## Ficheros de entrada
Los algoritmos aceptan datasets en formato **TSPLIB** (`.tsp`):

Ejemplo (`burma14.tsp`):

```tsp
NAME: burma14
TYPE: TSP
DIMENSION: 14
NODE_COORD_SECTION
1 16.47 96.10
2 16.47 94.44
...
14 20.09 94.55
EOF
```

---

## Desarrollo de la práctica

El programa en **Java** debe:
1. Permitir cargar datasets generados aleatoriamente o desde ficheros TSPLIB.
2. Mostrar los resultados en:
    - **Texto**: identificando el par de puntos más cercanos y la distancia.
    - **Gráfico**: puntos del dataset y línea que conecta los dos más cercanos.
3. Implementar **HeapSort o QuickSort** para la ordenación.
4. Incluir un estudio teórico del pseudocódigo y su complejidad.
5. Comparar experimentalmente los tiempos de ejecución para tamaños de dataset: `200, 500, 1500, 5000`.

---

## Funcionalidades mínimas del programa

1. **Crear dataset aleatorio (.tsp)**
    - Guardar en disco como `datasetN.tsp`.

2. **Cargar dataset en memoria**
    - Desde fichero o generado aleatoriamente.

3. **Comprobar estrategias**
    - Ejecutar las 4 estrategias y mostrar resultados con formato:  

Estrategia Punto1 Punto2 Distancia DistanciasCalc Tiempo(ms)
Exhaustivo ... ... ... ... ...
ExhaustivoPoda ... ... ... ... ...
DivideVenceras ... ... ... ... ...
DyV Mejorado ... ... ... ... ...


4. **Comparar todas las estrategias**
    - Ejecutar con diferentes tamaños (ej. 1000 a 5000).
    - Generar promedios de ejecución.

5. **Comparar 2 estrategias**
    - Mostrar tiempos y número de distancias calculadas.

---

## Consideraciones importantes
- El rendimiento depende de la distribución de los datos.
- En **caso medio**: el más eficiente suele ser *exhaustivo con poda*.
- En **peor caso** (todos los puntos con la misma coordenada `x`): el mejor es *Divide y Vencerás Mejorado*.

El programa debe permitir generar datasets para ambos casos:
- Caso medio (distribución aleatoria en `x` e `y`).
- Peor caso (todos con la misma `x`, variando solo `y`).

---

## Generación de datos aleatorios
Ejemplo en C++ para garantizar ausencia de duplicados:

```cpp
void Punto::rellenarPuntos(Punto *p, int n, bool peorCaso) {
  srand(time(NULL));
  if (peorCaso) {
    for (int i=0; i<n; i++) {
      double y = (rand()%1000+7) / ((double)i+1+i*0.100);
      p[i] = Punto(1, y, i+1);
    }
  } else {
    for (int i=0; i<n; i++) {
      double x = (rand()%4000+1) / ((double)(rand()%11+7)+0.37);
      double y = (rand()%4000+1) / ((double)(rand()%11+7)+0.37);
      p[i] = Punto(x, y, i+1);
    }
  }
}
