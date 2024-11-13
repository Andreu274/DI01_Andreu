DESCRIPCIÓ DE LES CLASSES

ABOUT
Aquesta part del projecte és una finestra "About" (Sobre nosaltres) que proporciona informació sobre els creadors de l'aplicació i els recursos utilitzats. La finestra "About" inclou informació com el nom de la persona responsable de l'aplicació i una referència a on es poden trobar els recursos utilitzats per al projecte (tipus de llicència, llibreries externes, etc.).

INTENTS
La classe Intents és una finestra gràfica (GUI) que permet als usuaris gestionar i revisar intents pendents associats amb vídeos. Aquesta finestra permet veure la llista d'intents pendents, reproduir i controlar la reproducció de vídeos, així com tornar a la finestra principal de l'aplicació. Aquesta classe forma part d'un sistema més gran que interactua amb una base de dades per emmagatzemar i recuperar intents.

USUARIS
La classe Java Usuaris defineix una finestra JFrame amb la funcionalitat de mostrar una llista d'usuaris i els seus intents associats de vídeo, permetent seleccionar i reproduir vídeos. La finestra inclou un reproductor de vídeo, una llista d'usuaris, una taula d'intents de vídeo, i botons per a posar en pausa/reprendre la reproducció del vídeo i per navegar fins al frame principal.

MAINFRAME
Aquesta classe Java, MainFrame, és una finestra gràfica d'una aplicació que esta orientada a la gestió d'usuaris i intents en el context d'un sistema anomenat "Pokegym". Utilitza la biblioteca Swing per crear la interfície d'usuari i proporciona un conjunt d'interaccions bàsiques per navegar entre diferents pantalles o seccions de l'aplicació.

MAINWINDOW
La classe MainWindow és la finestra inicial d'una aplicació en Java, dissenyada amb Swing, per gestionar l'inici de sessió i registre d'usuaris dins d'un sistema anomenat "Pokegym". La finestra proporciona diverses funcionalitats i opcions per als usuaris, incloent-hi la visualització d'informació de l'aplicació i un menú d'opcions.

LOGINDIALOG
La classe LoginDialog és una finestra de diàleg en Java dissenyada per gestionar el procés d'inici de sessió d'un usuari en una aplicació. Utilitza Swing per crear la interfície d'usuari i realitza validacions de les credencials d'usuari a partir de la informació emmagatzemada a la base de dades.



REGISTERDIALOG
És un diàleg de registre d'usuari en Java utilitzant Swing per a la interfície gràfica. El diàleg permet als usuaris crear un compte, emmagatzemant les seves dades (nom, correu electrònic, contrasenya) i determinant si l'usuari és instructor o no. També s'utilitza BCrypt per encriptar la contrasenya abans de guardar-la a la base de dades, millorant així la seguretat. 





RECURSOS UTILITZATS
Els recursos mes utilitzats han estat Stack Overflow i chatGPT,apart de la majoria de GitHub's de les dependencies utilitzades.

https://chatgpt.com
https://try.stackoverflow.co
https://github.com/JFormDesigner/FlatLaf
https://github.com/pyca/bcrypt
https://www.videolan.org/vlc/index.es.html



PROBLEMES

- He tengut problemes a l'hora de fer funcionar la llista dels intents ja que List no esta preparat per treballar amb objectes, canviant el tipus de llista a intents,fem que 
poguem treballar amb objectes i donar-nos mes llibertat,ja que si en un futur volem ensenyar qualsevol altre atribut de l'objecte ho podrem fer.

- Problemes tambe a la hora d'utilitzar el reproductor de video,primerament perque a la hora de instalar VLC, a vegades, s'ha de tornar a instalar perque el programa no ho detecta de primeres,tambe,per instalar les dependencies,es molt facil equivocarse aixi que s'ha de mirar be,quina es la que utilitzes.

- El major problema de tots, ha estat realmente, la poca documentación que hem trobat,la majoria de videos sobre aquests temes traten el tema amb molt poca profunditat,son molt basics i no ens han ajudat massa,tenguent en compte que duim una base molt pobre del primer any del FP.

- L'altre gran problema com he mencionat abans ha estat que duim una base tan dolenta amb el que pareix que esperen els profes,que en el meu cas me ha faltat temps,es cert que jo estic fent feina apart del curs pero la gent ha anat enrere com a norma general i en el meu cas per la falta de temps falten coses al programa.

- Un altre problema ha estat descubrir que realmente si que pots canviar el codi generat per NetBeans.



FUNCIONALITATS EXTRES
Realment l'unic implementat extra son alguns frames com l'about o el menú de botons i afegir un nou LookAndFeel per millorar la experiencia de l'usuari.

