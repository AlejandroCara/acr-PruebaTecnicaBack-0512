# acr-tsys-PruebaTecnicaBack-spring-0512

End points:

POST: "/user/add"
Para registrar usuaris a la aplicación, por el body hay que pasar la siguiente estructura json:<bt>

{<bt>
    "firstName" : "name",<bt>
    "lastName" : "lastName",<bt>
    "email" : "email@gmail.com",<bt>
    "password" : "pwd",<bt>
    "roles" : "USER"<bt>
}<bt>
<bt>
POST: "/login"<bt>
Para hacer login a la aplicación, devuelve el JWT token, hay que pasarle por el body la siguiente estructura json:<bt>
{<bt>
    "userName" : "email@gmail.com",<bt>
    "password" : "pwd"<bt>
}<bt>
<bt>
POST: "/party/add"<bt>
Para añadir una party a la aplicación, hay qye pasarle la siguiente estructura JSON:<bt>
{<bt>
    "name" : "party name",<bt>
    "game" : {<bt>
        "id" : gameId<bt>
    }<bt>
}<bt>
<bt>
PUT: "/party/join?id=1"<bt>
Para unir el usuario logeado a la party con el id pasada por la ID.<bt>
<bt>
<bt>
PUT: "/party/exit?id=1"<bt>
Para sacar al usuario logeado a la party con el id pasada por la ID.<bt>
<bt>
<bt>
GET: "/message/add"<bt>
Añade un mensaje a la aplicación, pasandole la siguiente estructura JSON:<bt>
{<bt>
    "message" : "contenido del mensaje",<bt>
    "created_at" : "",<bt>
    "updated_at" : "",<bt>
    "author" : {<bt>
        "id" : id_del_autor<bt>
    },<bt>
    "party" : {<bt>
        "id" : id_party<bt>
    }<bt>
}<bt>


