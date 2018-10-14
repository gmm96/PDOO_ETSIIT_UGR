# Descripción del problema: Napakalaki

Durante el transcurso de las sesiones de prácticas se va a desarrollar, por etapas, la implementación
de un juego de rol. Este proceso de implementación, a partir de la información y diagramas que se
irán suministrando, debe ayudar al alumno a entender y asimilar los conceptos que forman parte del
temario de esta asignatura.

### Napakalaki

El juego que se va a desarrollar se llama Napakalaki y está basado en un conocido juego de rol
diseñado por Steve Jackson llamado Munchkin. En nuestro juego participarán 3 jugadores cuyo
objetivo será alcanzar el nivel 10 antes que el resto. Al inicio del juego todos los jugadores tendrán
como nivel el valor 1 y el primero en alcanzar el nivel 10 será el ganador.

La dinámica del juego consiste en ir combatiendo con monstruos utilizando una serie de armas o
tesoros. Dependiendo de que se gane o pierda el combate se irá incrementando o decrementando el
nivel y ganando o perdiendo tesoros. Existirán por tanto dos barajas de cartas, una para los
monstruos contra los que se combate y otra para los tesoros que nos sirven de ayuda en esos
combates.

Entre los 3 jugadores se establecerán además relaciones de enemistad. A cada jugador se le asignará
al azar un archienemigo que necesariamente deberá ser uno de los otros dos jugadores.

### Los Tesoros

Cada tesoro posee un nombre, una cantidad llamada _bonus_ y un tipo. El bonus es utilizado para el
cálculo del nivel de combate de un jugador al enfrentarse a un monstruo. El tipo de los tesoros será
uno de los siguientes: de una mano, de dos manos, casco, calzado y armadura.

![Ejemplo de tesoro](https://raw.githubusercontent.com/gmm96/PDOO_ETSIIT_UGR/master/img/TreasureExample.png "Ejemplo de tesoro")


Cada jugador dispondrá de dos conjuntos de tesoros: los visibles (también llamados equipados) y
los ocultos. Los tesoros equipados son los que se utilizarán para el cálculo del nivel de combate de
cada jugador. Así, para calcular este nivel de combate se sumarán al nivel del jugador los bonus
proporcionados por todos los tesoros equipados. Los tesoros ocultos no intervienen en este cálculo.

Existen determinadas **restricciones** sobre los tesoros que podrá disponer un jugador en cada
instante:

- Solo podrá tener equipado un tesoro de cada tipo, salvo para el caso de tesoros de una mano de los
que podrá tener equipados hasta 2.
- Si se tienen equipado 1 ó 2 tesoros de una mano, no se podrá tener equipado ningún tesoro de dos
manos.
- Si se tiene equipado un tesoro de dos manos, no se podrá tener equipado ningún tesoro de una
mano.
- Solo podrá tener 4 tesoros ocultos como máximo.
- No será posible volver a ocultar cartas ya equipadas.

Si no se cumplen estas condiciones el estado del jugador sería inválido.

### Monstruos

Cada monstruo posee un nombre, un cierto nivel de combate, un _buen rollo_ y un _mal rollo_. El buen
rollo indica el incremento de nivel y/o tesoros ganados por el jugador si este consigue vencer al
monstruo. Por otro lado, el mal rollo representa el decremento de nivel a aplicar y/o tesoros (ocultos
y/o equipados) que perderá el jugador si no resulta vencedor en el combate.

![Ejemplo de monstruo](https://raw.githubusercontent.com/gmm96/PDOO_ETSIIT_UGR/master/img/MonsterExample.png "Ejemplo de monstruo")


### Desarrollo del juego

Al inicio del juego se decide al azar el jugador que comenzará la partida. Para los siguientes turnos
se seguirá el orden de las agujas del reloj para determinar el siguiente jugador.
Al inicio de la partida todos los jugadores tienen el nivel 1 y cada jugador comienza lanzando el
dado para determinar los tesoros de los que dispondrá para empezar. Si se obtiene un 1 se comienza
con 1 tesoro, si se obtiene entre 2 y 5 se comienza con 2 tesoros y si se obtiene un 6 se comienza
con 3 tesoros. Los tesoros que recibe el jugador siempre se añaden a sus tesoros ocultos.

Antes de cada combate, y antes de conocer el monstruo con el que se enfrentará, el jugador puede
equiparse los tesoros que desee siempre que cumpla las reglas sobre la cantidad y tipos de tesoros
que se pueden tener equipados. Equipar un tesoro implica quitarlo del conjunto de los ocultos y
pasarlo al de los equipados.

Una vez que el jugador está equipado destapará la carta que esté en el tope de la baraja de cartas de
monstruos para librar una batalla. El combate consiste en comparar el nivel de combate de ambos
contendientes.

Si el nivel de combate del jugador (su nivel actual sumado a los bonus de todos sus tesoros
equipados) es mayor que el nivel de combate del monstruo, el jugador resulta ganador y se aplica el
buen rollo asociado al monstruo. Esto le hará incrementar su nivel y/o recibir tesoros. Los tesoros
recibidos siempre se añaden al conjunto de tesoros ocultos.

Si el nivel de combate del jugador no es mayor que el del monstruo, el jugador pierde. Esto
significa que el jugador debe hacer frente al mal rollo asociado a ese monstruo. Esto hará que
disminuya su nivel y/o pierda tesoros. Si el mal rollo implica la pérdida de tesoros, se pedirá al
jugador que se descarte de un número o tipo de tesoros concretos para cumplirlo. No será posible
pasar de turno sin haber cumplido completamente el mal rollo. Finalmente, el nivel mínimo de un
jugador es 1 y por lo tanto, independientemente de lo indicado por el mal rollo, el jugador nunca
tendrá un nivel negativo o cero.

El cumplimiento del mal rollo siempre está condicionado a las cartas de las que dispone el jugador
en cada momento. Así, si el mal rollo indica que el jugador debe descartarse de una serie de tesoros
de los que el jugador no dispone, el jugador estará eximido de cumplir la parte del mal rollo que no
le es posible asumir. En el caso de que se indique que debe perder más tesoros de los que dispone el
jugador cumplirá el mal rollo dentro de sus posibilidades y en función de los tesoros de los que
dispone. Por ejemplo, si un mal rollo indicase que un jugador debe perder 2 armaduras ocultas y un
tesoro de una mano visible, si éste solo dispone de una armadura oculta y ningún tesoro de mano
visible, solo deberá descartarse de su única armadura oculta y el mal rollo se considerará cumplido.
De entre todos los tesoros que puedan hacer cumplir el mal rollo, el jugador puede elegir
descartarse de aquellos que desee. Por ejemplo, si el mal rollo le dice que debe descartarse un tesoro
visible, él puede decidir cuál.

Existe un tipo de mal rollo que implica la muerte del jugador, aunque se le permite seguir jugando.
Al aplicarlo, éste pierde todos los tesoros de los que dispone (tanto equipados como ocultos) y su
nivel quedará fijado en 1. Si un jugador muere, cuando vuelva a recibir el turno se le volverán a
asignar tesoros utilizando el mismo método que se utiliza al comienzo de la partida.

![Descripción del juego](https://raw.githubusercontent.com/gmm96/PDOO_ETSIIT_UGR/master/img/GameDescription.png "Descripción del juego")


Una vez terminado el combate y la aplicación del mal o buen rollo, el jugador podrá equiparse
tesoros y/o descartar tesoros.

A continuación el jugador podrá robar un tesoro a su archienemigo. Cada jugador podrá hacerlo una
única vez en en la partida. El robo de un tesoro consistirá en elegir uno de los tesoros ocultos de su
archienemigo y añadirlo a su lista de tesoros ocultos. El jugador que realiza el robo tendrá que
elegir la carta de tesoros a ciegas y por lo tanto sin saber la carta que está robando.

Una vez finalizado el hipotético proceso de robo de tesoros, si el jugador está en un estado válido en
cuanto a tesoros equipados y ocultos y en lo relativo al cumplimiento del mal rollo, se pasará de
turno para que juegue el siguiente jugador.

### Jugadores sectarios

Durante el desarrollo de las prácticas se introducirá un aspecto adicional en lo relativo a los
jugadores. En caso de que un jugador pierda un combate y no muera al aplicarse el mal rollo, a este
se le ofrece la posibilidad de volver a lanzar el dado. Si obtiene un 6 el jugador pasará a ser un
jugador sectario.

La transformación en jugador sectario implica tomar una carta de sectario. Esta carta indicará un
determinado nivel. Así, el nivel de combate de un jugador sectario será el nivel de combate de un
jugador no sectario aumentado en un 20% , al que además se le suma el nivel que indica su carta de
sectario multiplicado por el número de jugadores sectarios en juego.

Los jugadores sectarios se comportan también de forma distinta al ser robados ya que en vez de un
tesoro oculto deberán ceder una carta de tesoro visible. En cualquier caso, la carta perdida se
determinará al azar y el jugador que va a ser receptor de la misma no podrá elegir una concreta.

En este punto se añadirán nuevas cartas de monstruos que incluyen un aumento o reducción del
nivel de combate cuando se enfrentan a jugadores sectarios.

Una vez que un jugador adquiere el carácter de sectario nunca pierde esta condición.