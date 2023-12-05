# acr-tsys-PruebaTecnicaBack-spring-0512

End points:

POST: "/user/add"
Para registrar usuaris a la aplicación, por el body hay que pasar la siguiente estructura json:

{
    "firstName" : "name",
    "lastName" : "lastName",
    "email" : "email@gmail.com",
    "password" : "pwd",
    "roles" : "USER"
}

POST: "/login"
Para hacer login a la aplicación, devuelve el JWT token, hay que pasarle por el body la siguiente estructura json:
{
    "userName" : "email@gmail.com",
    "password" : "pwd"
}


POST: "/party/add"
Para añadir una party a la aplicación, hay qye pasarle la siguiente estructura JSON:
{
    "name" : "party name",
    "game" : {
        "id" : gameId
    }
}


PUT: "/party/join?id=1"
Para unir el usuario logeado a la party con el id pasada por la ID.


PUT: "/party/exit?id=1"
Para sacar al usuario logeado a la party con el id pasada por la ID.


GET: "/message/add"
Añade un mensaje a la aplicación, pasandole la siguiente estructura JSON:
{
    "message" : "contenido del mensaje",
    "created_at" : "",
    "updated_at" : "",
    "author" : {
        "id" : id_del_autor
    },
    "party" : {
        "id" : id_party
    }
}


