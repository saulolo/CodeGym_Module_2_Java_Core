#  Proyecto Final del Módulo 2: Simulador de Ecosistema en la Isla 🏝️

_Autor: Saul Echeverri_   
_Edición: 2025_

## Tabla de Contenidos 📚

- [Comenzando](#comenzando)
    - [Pre-requisitos](#pre-requisitos)
    - [Instalación](#instalacion)
        - [Requisitos Previos](#requisitos-previos)
        - [Clonar el Repositorio](#clonar-el-repositorio)
    - [Despliegue](#despliegue)
        - [Despliegue Local](#despliegue-local)
- [Construido con](#construido-con)
- [Estructura del proyecto y flujo](#estructura-del-proyecto-y-flujo)
    - [Estructura](#estructura-)
    - [Flujo](#flujo-)
- [Contribuyendo](#contribuyendo)
    - [Reglas para Enviar Solicitudes de Extracción (Pull Requests)](#reglas-para-enviar-solicitudes-de-extraccion-pull-requests-)
    - [Informar Problemas](#informar-problemas)
    - [Comunicación](#comunicacion)
    - [¿Dónde obtener ayuda?](#donde-obtener-ayuda)
- [Autor](#autor)
- [Licencia](#licencia)
- [Expresiones de Gratitud](#expresiones-de-gratitud)
- [Créditos](#creditos)

## Comenzando 🚀
Este proyecto implementa un **Simulador de Ecosistema** simple basado en turnos, donde diversas especies de animales interactúan entre sí y con el entorno en una isla cuadriculada. La simulación modela comportamientos básicos como comer, moverse, reproducirse y la muerte por hambre, así como las interacciones depredador-presa.

El propósito de este proyecto es demostrar cómo se pueden simular sistemas complejos utilizando principios de la Programación Orientada a Objetos (POO) en Java, incluyendo herencia, polimorfismo y encapsulamiento.

Este repositorio es de carácter **educativo** y está destinado a estudiantes y profesionales que deseen aprender más sobre el diseño de simulaciones, concurrencia básica y POO en Java.

### Pre-requisitos 📋

Para ejecutar este proyecto, asegúrate de tener instalados los siguientes elementos en tu entorno local:

- **Java Development Kit (JDK)**: Este proyecto requiere **JDK 17 o superior**. Puedes descargar e instalar JDK desde [Oracle](https://www.oracle.com/java/technologies/javase-downloads.html) o [OpenJDK](https://adoptopenjdk.net/).

  Para verificar si Java está instalado, puedes abrir una terminal y ejecutar el siguiente comando:

   ```shell
   java -version

### Instalación 🔧
A continuación, se describen los pasos para configurar y ejecutar este proyecto Java en tu entorno de desarrollo.

#### Requisitos Previos
- **Git**: instalalo en su sitio oficial [Git](https://git-scm.com/) si deseas clonar el repositorio.

#### Clonar el Repositorio

Para comenzar, clona este repositorio en tu máquina local usando Git:

```shell
git clone https://github.com/saulolo/CodeGym_Module_2_Java_Core.git
```

**Nota:**  Asegúrate de que tu sistema tenga configuradas las variables de entorno JAVA_HOME y PATH para que apunten a
tu instalación de JDK.

## Despliegue 📦

En esta sección, se proporcionan instrucciones y notas adicionales sobre cómo ejecutar el simulador.

### Despliegue Local 🏠

Para ejecutar el simulador en tu propio entorno local, sigue estos pasos:
1. **Configuración de Variables de Entorno**: Asegúrate de que las variables de entorno necesarias, como `JAVA_HOME`,
   estén configuradas correctamente.

2. **Compilación y Ejecución**: Compilación y Ejecución: Este proyecto está configurado para ser compilado y ejecutado 
directamente desde un IDE como [IntelliJ IDEA](https://www.jetbrains.com/idea/), [Eclipse](https://eclipseide.org/), 
[VS Code](https://code.visualstudio.com/) o cualesquier otro IDE compatible con JAVA, o usando un 
sistema de construcción como Maven.
   
Desde un IDE (Recomendado):

* Importa el proyecto como un proyecto Maven.
* Localiza la clase
```shell
org.educatiom.lesson20_ProyectoFinalModulo2.simulacion.mainSimulador
```
* Ejecuta el método main de esta clase.

Usando Maven (desde la raíz del proyecto lesson20_ProyectoFinalModulo2):
```shell
mvn clean install
```
El proyecto se ejecutará en tu servidor local en http://localhost:8080.

El simulador imprimirá su progreso y estadísticas en la consola.


## Construido con 🛠️

Este proyecto fue construido utilizando las siguientes herramientas y tecnologías:

* **Java**: El lenguaje de programación principal utilizado en el proyecto (JDK 17+).
* **Maven**: Gestor de dependencias que se utilizó para administrar las bibliotecas y las dependencias del proyecto.
  Puedes encontrar más información sobre Maven en [https://maven.apache.org/](https://maven.apache.org/).
* **PlantUML**: Herramienta utilizada para generar el diagrama de clases UML que visualiza la arquitectura del sistema.
Lo puedes agregar a tu IDE de preferencia mediante los puggins; para mayor información, visita la documentación en  [https://plantuml.com/es/](https://plantuml.com/es/).


## Estructura del proyecto y flujo 🧩
Este proyecto se organiza modularmente para simular un ecosistema. Las clases se agrupan por su rol: desde la 
representación del mundo (`modelo`) y la definición de los seres vivos (`seresvivos`) con sus jerarquías de herencia y 
comportamientos polimórficos, hasta las utilidades (`utilidades`) y la lógica principal de la simulación (`simulacion`).
El flujo del programa se basa en turnos, donde los animales interactúan dinámicamente con su entorno y entre sí, 
reflejando ciclos de vida, alimentación y reproducción.

### Estructura 🏗️
```
org.educatiom.lesson20_ProyectoFinalModulo2/
├── diagramaUML/
│   └── Diagrama UML.png
├── modelo/
│   ├── Isla.java
│   └── Ubicacion.java
├── seresvivos/
│   ├── Aguila.java
│   ├── Animal.java
│   ├── Boa.java
│   ├── Bufalo.java
│   ├── Caballo.java
│   ├── Cabra.java
│   ├── Carnivoro.java
│   ├── Ciervo.java
│   ├── Conejo.java
│   ├── Herbivoro.java
│   ├── Jabali.java
│   ├── Lobo.java
│   ├── Oruga.java
│   ├── Oso.java
│   ├── Oveja.java
│   ├── Pato.java
│   ├── Planta.java
│   ├── Raton.java
│   └── Zorro.java
├── simulacion/
│   └── mainSimulador.java
└── utilidades/
    └── TablaProbabilidades.java
```
### Flujo ⏩ ️
```
+-----------------------------------+
|      INICIO DE LA SIMULACIÓN      |
|      (mainSimulador.main())       |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|     Inicialización de la Isla     |
|            (Isla.java)            |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|        Poblamiento Inicial        |
|     poblarIslaInicialmente()      |
| Plantas y Animales en Ubicaciones |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|  Imprimir Estadísticas Iniciales  |
|   (Isla.imprimirEstadisticas())   |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|    BUCLE PRINCIPAL DE TURNOS      |
|        realizarTurno()            |
|     Iteración por cada Turno      |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|      Acciones de los Animales     |
|        Animal.vivirTurno()        |
| - Aumento de Hambre               |
| - Comer (Planta/Presa)            |
| - Movimiento por la Isla          |
| - Reproducción                    |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|   Remoción de Animales Muertos    |
|    (Por hambre o depredación)     |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|     Regeneración de Plantas       |
|   (Isla.generarNuevasPlantas())   |
+-----------------------------------+
                 |
                 v
+-----------------------------------+
|  Imprimir Estadísticas del Turno  |
|   (Isla.imprimirEstadisticas())   |
+-----------------------------------+
                 | (Si hay más turnos, 
                 v  vuelve aL bucle)
+-----------------------------------+
|        FIN DE LA SIMULACIÓN       |
+-----------------------------------+
```

## Contribuyendo 🖇️

¡Gracias por tu interés en contribuir a este proyecto! Aquí hay algunas reglas y pautas para enviar contribuciones:

### Reglas para Enviar Solicitudes de Extracción (Pull Requests) 🔀

1. Antes de enviar una solicitud de extracción, asegúrate de que tu código esté bien probado y sea compatible con la
   rama principal.

2. Sigue un estilo de código consistente.

3. Si tu contribución agrega nuevas características, proporciona documentación clara sobre cómo utilizar esas
   características.
### Informar Problemas 🐞

Si encuentras errores o problemas en el proyecto, por favor, abre un issue para informe. Proporciona detalles claros
sobre el problema, incluyendo pasos para reproducirlo.

### Comunicación 💬

Me encanta escuchar tus ideas y responder tus preguntas. Siempre puedes [contactarme](https://www.linkedin.com/in/saul-echeverri-duque/) para discutir el proyecto o plantear cualquier pregunta que tengas.

¡Espero con ansias tus valiosas contribuciones!

### ¿Dónde obtener ayuda? 🆘

Si tienes preguntas o necesitas ayuda durante el proceso de contribución, no dudes en [contactarme](https://www.linkedin.com/in/saul-echeverri-duque/) o abrir un issue para obtener asistencia.

¡Espero trabajar contigo en este proyecto y agradeceré tu ayuda para mejorarlo!


## Autor ✒️

¡Hola! Soy ***Saul Echeverri Duque*** 👨‍🦲 , el creador y desarrollador de este proyecto. Permíteme compartir un poco sobre mi
formación y experiencia:

### Formación Académica 🎓

- 👨‍🎓 Graduado en Ingeniería de Alimentos por la Universidad de Antioquia, Colombia.
- 📖 Titulado en Tecnología en Análisis y Desarrollo de Software por el SENA, Colombia.

### Pasión por la Programación 👨‍💻

- 💻 Mi viaje en el mundo de la programación comenzó en el 2021, y desde entonces, he estado inmerso en el emocionante
  universo del desarrollo de software.
- ♨️ Uno de mis mayores intereses y áreas de enfoque es Java, y este proyecto es el resultado de mi deseo de compartir
  conocimientos y experiencias relacionadas con este lenguaje.
- 🤝 Estoy emocionado de colaborar y aprender junto a otros entusiastas de Java.

Estoy agradecido por la oportunidad de compartir este proyecto contigo y espero que te sea útil en tu propio camino de
aprendizaje y desarrollo. Si tienes alguna pregunta, sugerencia o simplemente quieres charlar sobre tecnología, no dudes
en ponerte en contacto conmigo. ¡Disfruta explorando el mundo de Java!

¡Gracias por ser parte de este proyecto! 😊


## Licencia 📄

Este proyecto se basa en el curso de "CodeGym University" y se
desarrolla con fines educativos y de aprendizaje del lenguaje de Java. La utilización de los
ejercicios y contenido del proyecto se realiza en concordancia con los derechos de uso permitidos por el autor y su curso.

**Nota Importante**: Este proyecto no se distribuye bajo una licencia de código abierto estándar, ya que está destinado
principalmente para fines personales y educativos. Si deseas utilizar o distribuir el contenido de este proyecto más
allá de los fines educativos personales, asegúrate de obtener los permisos necesarios del autor.

Es importante respetar los derechos de autor y las restricciones legales asociadas con el contenido del curso en el que
se basa este proyecto.


## Expresiones de Gratitud 🎁

Quiero expresar mi más sincero agradecimiento al docente [Said Olano](https://www.linkedin.com/in/josesaid/?originalSubdomain=mx),
profesor del curso de "CodeGym" grupo Algoritmo, cuya enseñanza ha sido la fuente de inspiración y aprendizaje fundamental 
para este proyecto. Su dedicación a la enseñanza y la claridad de su curso han sido invaluables para mí formación.

Si encuentras este proyecto útil y te gustaría expresar tu gratitud de alguna manera, aquí hay algunas opciones:

* Comenta a otros sobre este proyecto 📢: Comparte este proyecto con tus amigos, colegas o en tus redes sociales para
  que otros también puedan beneficiarse de él.

* Invita una cerveza 🍺 o un café ☕ a alguien del equipo: Siéntete libre de mostrar tu aprecio por el esfuerzo del
  autor o del único miembro del equipo (yo) comprándoles una bebida virtual.

* Da las gracias públicamente 🤓: Puedes expresar tu agradecimiento públicamente en el repositorio del proyecto, en los
  comentarios, o incluso en tu blog personal si lo deseas.

* **Dona a través de una cuenta bancaria** 💰: Si prefieres hacer una donación en efectivo o mediante transferencia
  bancaria, puedes hacerlo a la siguiente cuenta de ahorros en Bancolombia: 2301-5881-151. Tu generosidad será muy
  apreciada y contribuirá al mantenimiento y mejora de este proyecto.

¡Gracias por ser parte de este viaje de aprendizaje y desarrollo!



---
## Créditos 📜

Este proyecto fue desarrollado con ❤️ por [Saul Echeverri](https://github.com/saulolo) 😊.

Si tienes preguntas, comentarios o sugerencias, no dudes en ponerte en contacto conmigo:

- GitHub: [Saul Hernando Echeverri Duque](https://github.com/tuusuario) 🌐
- Correo Electrónico: saulolo@gmail.com 📧
- LinkedIn: [Saul Echeverri](https://www.linkedin.com/in/saul-echeverri-duque/) 💼

