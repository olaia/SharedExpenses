# Shared Expenses

<em>Este README en otros idiomas: [English](README.md), [Español](README.es.md).</em>

<em>***Disclaimer: La aplicación a día de hoy sólo está disponible en Inglés.</em>

Shared Expenses es una aplicación backend creada con Spring Boot.

Las dependencias son gestionadas a través de Gradle.

Shared Expenses es una aplicación que proporciona soporte a grupos de amigos que quieran tener gastos compartidos y llevar un balance de cuánto (se le)debe a cada participante. 


# Features
1. Añadir usuario
    1. Nombre de usuario (Campo obligatorio)
    2. Nombre
    3. Apellido
2. Listar todos los usuarios 
    1. Nombre de usuario
    2. Nombre
    3. Apellido
    4. Balance (Cantidad que (se le)debe, en €uros) 
3. Añadir gasto
    1. Nombre de usuario (Campo obligatorio)
    2. Cantidad (Campo obligatorio, en €uros)
    3. Descripción
4. Listar todos los gastos
    1. Nombre de usuario
    2. Cantidad (En €uros)
    3. Descripción
    4. Fecha

## Requisitos
1. [Java(11)](http://java.com)

## Uso
Arrancar el servidor.
```
java -jar ./build/libs/SharedExpenses-0.0.1-SNAPSHOT.jar
```

## Compilación
Compilación de código fuente.
```
./gradlew build
```
Compilación y ejecución.
```
./gradlew bootRun
```

## Persistencia de datos
Los datos se persisten via Spring Data, utilizando JPA.

Se ha utilizado una BBDD MySQL. Se proporciona una copia de ejemplo en el código fuente para que los desarrolladores puedan probar la app.

## Importar la base de datos
Se proporciona una BBDD de ejemplo. Se puede importar de la siguiente manera.
```
mysql --user=springuser --password=ThePassword -h localhost shared_expenses < shared_expenses.sql 
```

## Asunciones
1. El nombre de usuario es un campo obligatorio. Es lo que se utiliza para identificar usuarios.
   De esta manera puede haber personas con mismo nombre y apellido.
2. Si un usuario tiene balance negativo, significa que el grupo le debe dinero. El grupo está en deuda.
3. Un usuario puede actualizar su nombre y apellidos, el balance y el nombre de usuario se mantienen.
4. La moneda utilizada es siempre €uros.

## Decisiones Técnicas
1. El back y el front intercambian fechas en formato EPOCH. La BBDD almacena formato legible al humano, en string.

## Nice to have
1. Tests. Para garantizar el correcto funcionamiento y escalabilidad del proyecto.
2. Contenedores Docker que permiten al desarrollador empaquetar una aplicación con todas las partes necesarias, librerías y otras dependencias, para poder entregar el proyecto como un único paquete.
3. Deuda nominal. La aplicación indicaría cuánto debe pagar y a quién para que el grupo esté en balance 0€.
