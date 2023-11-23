# Instituto Nacional Electoral 

## By: Leonardo Reyes Martínez, Aplicación web desarrollada en Java para simular el conteo de votos para las elecciones del INE.

- Para ingresar a la aplicación es necesario ingresar usuario y contraseña (dos tipos de usuarios, administrador y votante). El usuario tiene 5 intentos posibles para acceder a la aplicación:
![Alt text](./assets/image.png)
- En el caso de que el usuario agote sus 5 intentos, se bloquea la aplicación:
![Alt text](./assets/image-1.png)
- Dashboard del Admin: El administrador es el único que puede iniciar el sistema.
 - Formulario para ingresar el número de votantes:
![Alt text](./assets/image-2.png)
- Registra el número de votantes introducido previamente:
![Alt text](./assets/image-3.png)
- Para registrar a un votante es necesario su nombre, apellidos, edad y fecha de nacimiento, considerando que si no es mayor a 18 años, no puede ser registrado:
 ![Alt text](./assets/image-4.png)
- Una vez que se ingresó al sistema el administrador ingresa el número de votantes en su casilla, únicamente el número de votantes seleccionados por el administrador son los que podrán efectuar su voto.  En caso de que quiera ingresar mas votantes, le arrojara este error: 	
 ![Alt text](./assets/image-5.png)
- El administrador es el único que puede consultar los datos de los votantes que registró
![Alt text](./assets/image-6.png)
- El administrador es el único que puede consultar los resultados de las votaciones, partido y candidato ganador, mostrar si existe empate, cantidad de votos por partido y el total de los votantes:
![Alt text](./assets/image-7.png)
- El votante para poder ingresar y efectuar su voto deberá ingresar su id, nombre completo y fecha de nacimiento:
![Alt text](./assets/image-8.png)
- El votante puede seleccionar entre tres partidos políticos, PRI, PAN Y MORENA, cada uno con su respectivo candidato:
![Alt text](./assets/image-9.png)
- Un votante que ya efectúo su voto no podrá volver a realizarlo:
Hasta que el número de votantes totales coincida con la suma total de los votos, determina el ganador: 
![Alt text](./assets/image-10.png)
