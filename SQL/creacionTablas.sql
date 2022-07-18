create database preguntas_respuestas;

use  preguntas_respuestas;

CREATE TABLE historicousuario (
	id int NOT NULL AUTO_INCREMENT, 
    nombreJugador nvarchar (300) Not Null,
    puntos int not null,
    PRIMARY KEY(id)
);

CREATE TABLE preguntas
(
		id int NOT NULL AUTO_INCREMENT,
		 pregunta nvarchar (300) Not null,
		Idnivel int Not null,
         PRIMARY KEY(id)
);

create table opciones_respuesta
(
				id int NOT NULL AUTO_INCREMENT,
		Idpregunta int not null ,
		IDnivel int not null,
		letra nvarchar (800) not null,
		descripción nvarchar (800) not null,
		respuestacorrecta bit not null,
        		PRIMARY KEY(id)

);


INSERT preguntas (Id, pregunta, Idnivel)
VALUES
 (1, '¿Qué son las palabras reservadas?', 1),
  (2, '¿Qué codificación utiliza solamente 0 y 1? ', 1),
  (3, '¿Qué es un bit?  ', 1),
  (4, '¿Cúal de los siguientes números es de tipo float? ', 1),
  (5, 'En una variable tipo string se pueden guardar:' , 1),
  (6, '¿ Que es un IDE?' , 2),
(7, '¿Qué significan las siglas "www"?' , 2),
(8, '¿Cuál es la distribución de Linux más usada?' , 2),
(9, '¿Cuál de las siguientes variables está escrita correctamente?' , 2),
(10,'¿Qué significa CLR?' , 2),
(11,'¿ Cúal de las siguientes  variables locales están escritas correctamente usando camel Case?' , 3),
(12,'¿Los operadores  booleanos son aquellos que  devuelven un true o un false, dentro de los operadores Booleanos está el conectivo lógico and, este operador devuelve un true si:' , 3),
(13,'Si se tiene la siguiente cadena de texto S = “hOlA MunDo” al aplicar el s.lower () , qué transformación tendrá la cadena de texto:' , 3),
 (14,'¿Para qué sirven las variables?' , 3),
 (15,'¿Se puede cambiar el valor de una constante?' , 3),
 (16,'¿Qué bucle usarías para recorrer una lista de elementos?' , 4),
 (17,'¿Qué hace el operador ++?' , 4),
 (18, '¿Es obligatorio el uso de else dentro de un condicional If?' , 4),
 (19, '¿Cuál es la diferencia entre un método y una función?' , 4),
 (20, '¿ Qué se puede entender por lenguaje de programación?' , 4),
 (21, '¿Qué es una base de datos?' , 5),
 (22, '¿Qué es un algoritmo?' , 5),
 (23, '¿Que es una variable de bandera?' , 5),
 (24, '¿Cual es la mejor forma de consumir librerías de terceros?' , 5),
 (25, 'No sirve Do\ While para iterar sobre una lista de elementos' , 5);


INSERT opciones_respuesta (id, Idpregunta, IDnivel,letra, descripción, respuestacorrecta)
VALUES
(1, 1, 1, 'a' , 'Son las palabras que usamos para definir variables', 0),
  (2, 1, 1, 'b' , 'Son las palabras que usa el compilador para transformar el código en código máquina', 0),
  (3, 1, 1, 'c' , 'Son las palabras que no podemos usar; porque tienen un significado especial para el compilador', 1),
  (4, 1, 1, 'd' , 'Es la palabra que se reserva en memoria para usarla posteriormente', 0),

  (5, 2,1, 'a' , 'Binario', 1),
  (6, 2,1, 'b' , 'jeroglíficos', 0),
  (7, 2,1, 'c' , 'Castellano', 0),
  (8, 2,1, 'd' , 'C#', 0),

  (9,  3, 1, 'a' , 'La unidad más pequeña de almacenamiento', 1),
  (10, 3, 1, 'b' , 'Unidad de medida de la velocidad del cpu', 0),
  (11, 3, 1, 'c' , 'La unidad más grande de almacenamiento', 0),
  (12, 3, 1, 'd' , 'Es una unidad de medida de longitud', 0),

  (13, 4, 1, 'a' , '“ocho”', 0),
  (14, 4, 1, 'b' , '3/0', 0),
  (15, 4, 1, 'c' , '3.6', 1),
  (16, 4, 1, 'd' , '2.5X10^41', 0),

  (17, 5, 1, 'a' , 'cadenas de texto ', 1),
  (18, 5, 1, 'b' , 'mapas', 0),
  (19, 5, 1, 'c' , 'dibujos', 0),
  (20, 5, 1, 'd' , 'diccionarios', 0),

  (21, 6, 2, 'a' , 'Un entorno de desarrollo integrado', 1),
  (22, 6, 2, 'b' , 'Identificador único excepcional', 0),
  (23, 6, 2, 'c' , 'Significa intellisense DEscription', 0),
  (24, 6, 2, 'd' , 'Es un lenguaje de programación', 0),

  (25, 7, 2, 'a' , 'Windows world  walk', 0),
  (26, 7, 2, 'b' , 'World Wide Web', 1),
  (27, 7, 2, 'c' , 'Wait war warning', 0),
  (28, 7, 2, 'd' , 'Wash water white', 0),

  (29, 8, 2, 'a' , 'Windows', 0),
  (30, 8, 2, 'b' , 'Excel', 0),
  (31, 8, 2, 'c' , 'Ubuntu', 1),
  (32, 8, 2, 'd' , 'Mac', 0),

  (33, 9, 2, 'a' , 'string saludoFormal = buenos días;', 0),
  (34, 9, 2, 'b' , 'string saludoFormal = “buenos” días', 0),
  (35, 9, 2, 'c' , 'string saludoFormal = buenos “días”;', 0),
  (36, 9, 2, 'd' , 'string saludoFormal = “buenos días”;', 1),

  (37, 10, 2, 'a' , 'Common Lite Read', 0),
  (38, 10, 2, 'b' , 'Common language runtime', 1),
  (39, 10, 2, 'c' , 'Common Language read', 0),
  (40, 10, 2, 'd' , 'Común  la risa', 0),

  (41, 11, 3, 'a' , 'string ESTOESUNAVARIABLE = “hola”;', 0),
  (42, 11, 3, 'b' , 'string EstoEsUnaVariable = “hola”;', 0),
  (43, 11, 3, 'c' , 'string estoEsUnaVariable = “hola”;', 1),
  (44, 11, 3, 'd' , 'string estoesuna variable = “hola”;', 0),

  (45, 12, 3, 'a' , 'Si  ambos valores son true ', 1),
  (46, 12, 3, 'b' , 'Si ambos valores son false', 0),
  (47, 12, 3, 'c' , 'Siempre es true', 0),
  (48, 12, 3, 'd' , 'Si un valor es true y el otro es false', 0),

  (49, 13, 3, 'a' , '“hola mundo”', 1),
  (50, 13, 3, 'b' , 'HOLA MUNDO', 0),
  (51, 13, 3, 'c' , 'Hola Mundo', 0),
  (52, 13, 3, 'd' , 'Hola_mundo', 0),

  (53, 14, 3, 'a' , 'Para realizar operaciones', 0),
  (54, 14, 3, 'b' , 'Para almacenar valores y operar con ellos', 1),
  (55, 14, 3, 'c' , 'Para asignar valores que no se pueden modificar en tiempo de ejecución', 0),
  (56, 14, 3, 'd' , 'Para variar la información', 0),

  (57, 15, 3, 'a' , ' Si se puede pero no es recomendable hacerlo', 0),
  (58, 15, 3, 'b' , '  Si', 0),
  (59, 15, 3, 'c' , 'No se puede', 1),
  (60, 15, 3, 'd' , 'se puede hacer solo cuando la constante sea de tipo entero', 0),

  (61, 16, 4, 'a' , 'if', 0),
  (62, 16, 4, 'b' , 'Switch', 0),
  (63, 16, 4, 'c' , 'Diccionario', 0),
  (64, 16, 4, 'd' , 'for y foreach ambos sirven', 1),

  (65, 17, 4, 'a' , 'Ese operador no existe', 0),
  (66, 17, 4, 'b' , 'Es el operador de la suma', 0),
  (67, 17, 4, 'c' , 'El operador suma 1 a un valor entero asignado', 1),
  (68, 17, 4, 'd' , 'El operador resta 2 a un valor entero asignado', 0),

  (69, 18, 4, 'a' , 'Si', 0),
  (70, 18, 4, 'b' , 'No', 1),
  (71, 18, 4, 'c' , 'Solo si el condicional If está dentro de un for', 0),
  (72, 18, 4, 'd' , 'Solo es obligatorio si el if está dentro de un switch', 0),

  (73, 19, 4, 'a' , 'Un método acepta que se le pasen parámetros y una función no', 0),
  (74, 19, 4, 'b' , 'Un método puede devolver o no resultados, una función devuelve siempre resultado', 1),
  (75, 19, 4, 'c' , 'Es lo mismo se pueden llamar de ambas formas', 0),
  (76, 19, 4, 'd' , 'Una función solo se puede usar en .Net Core', 0),

  (77, 20, 4, 'a' , 'Una manera de comunicarse con el hardware', 0),
  (78, 20, 4, 'b' , 'Una manera definida para escribir instrucciones claras para programar aplicaciones de alto nivel.', 1),
  (79, 20, 4, 'c' , 'Lo relacionado con la codificación de páginas web y sitios interactivos', 0),
  (80, 20, 4, 'd' , 'Una forma de diseñar código para la máquina', 0),

  (81, 21, 5, 'a' , 'Un repositorio de datos', 0),
  (82, 21, 5, 'b' , 'Es un servidor que permite persistir información o datos concretos', 1),
  (83, 21, 5, 'c' , 'Es un grupo de datos efímeros', 0),
  (84, 21, 5, 'd' , 'Es una colección de datos o información concreta', 0),

  (85, 22, 5, 'a' , 'Código fuente', 0),
  (86, 22, 5, 'b' , 'Instrucciones lógicas con un propósito específico', 1),
  (87, 22, 5, 'c' , 'Una función matemática', 0),
  (88, 22, 5, 'd' , 'Una estructura programada orientada a una sintaxis', 0),

  (89, 23, 5, 'a' , 'Es una variable lógica que se utiliza para conservar el estado (verdadero o falso) de una condición, la cual toma valores binarios 1= si y 0 = no', 1),
  (90, 23, 5, 'b' , 'Es un triángulo con colores', 0),
  (91, 23, 5, 'c' , 'Es un tipo de variable', 0),
  (92, 23, 5, 'd' , 'Es una palabra reservada', 0),

  (93, 24, 5, 'a' , 'Referenciando al proyecto que genera la librería', 0),
  (94, 24, 5, 'b' , 'Referenciando directamente la librería en el proyecto', 0),
  (95, 24, 5, 'c' , 'Usando paquetes nuget', 1),
  (96, 24, 5, 'd' , 'Instanciando la librería', 0),

  (97, 25, 5, 'a' , 'No es su uso principal, pero sí se puede', 0),
  (98,  25, 5, 'b' , 'Si, sirve para eso', 0),
  (99, 25, 5, 'c' , 'Si, solo si la expresión evaluada siempre sea True', 0),
  (100,25, 5, 'd' , 'No, para eso se utilizan el for o el foreach', 1);
