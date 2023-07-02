<h2>Learning project for Spring Boot with MongoDB integration with CRUD operations</h2>
<h5>Technology Used - </h5>
<ul>
	<li>SpringBoot 3.1.0</li>
	<li>Java - OpenJDK 17.0.2</li>
	<li>MongoDB - 6.0.6</li>
</ul>
<h4>API Documentation - </h4>
<h5><u>Get Movies List:</u> </h5>
<p><u>Api Details:</u> Rest API to get list of Movies.</p>
URL endpoint - {hostname}/movie/movies<br />
http method - "GET"<br />
produces only "application/json"
<pre>
responsebody -
{
    "error": false,
    "message": null,
    "data": [
        {
            "_id": "batmanmovie2022",
            "movieName": "The Batman",
            "leadActor": "Robert Pattinson",
            "is3D": false
        },
        {
            "_id": "flashmovie2023",
            "movieName": "The Flash",
            "leadActor": "Micheal Keaton",
            "is3D": false
        },
        {
            "_id": "jokermovie2021",
            "movieName": "Joker",
            "leadActor": "Joaquin Phoenix",
            "is3D": false
        }
    ]
}
</pre>
<h5><u>Add New Movie: </u></h5>
<p><u>Api Details:</u> Rest API to add new movie to the database.</p>
URL endpoint - {hostname}/movie/addmovie<br />
http method - "POST"<br />
produces only "application/json"
<pre>
requestbody -
{
    "_id": "jokermovie2021",
    "movieName": "Joker",
    "leadActor": "Joaquin Phoenix",
    "is3D": false
}
responsebody[success] -
{
    "error": false,
    "message": null,
    "data": {
        "_id": "jokermovie2021",
        "movieName": "Joker",
        "leadActor": "Joaquin Phoenix",
        "is3D": false
    }
}
responsebody[error if movie already exists] -
{
    "error": true,
    "message": "Movie already exists!",
    "data": null
}
responsebody[error if any issue caused during inserting the Movie into the database] -
{
    "error": true,
    "message": "Movie insertion failed!",
    "data": null
}
<b>Empty or null value in '_id' and 'movieName' will return error in the response for the field. '_id' value must be unique.<br />Throws error in response if '_id' or 'movieName' already exists.</b>
</pre>
<h5><u>Delete a Movie: </u></h5>
<p><u>Api Details:</u> Rest API to delete a movie from the database.</p>
URL endpoint - {hostname}/movie/deletemovie?cinamename={moviename}<br />
http method - "DELETE"<br />
<pre>
cinamename = The Batman<br />
produces only "application/json"
responsebody[success] -
{
    "error": false,
    "message": "Movie deleted successfully!",
    "data": null
}
responsebody[error if no Movies found in the database] -
{
    "error": true,
    "message": "Movie not found with name Joker",
    "data": null
}
</pre>
<h5><u>Update a Movie by name: </u></h5>
<p><u>Api Details:</u> Rest API to update a movie by name.</p>
URL endpoint - {hostname}/movie/updatemoviebyname?originalname={movie_original_name}&newname={movie_new_name}<br />
http method - "PUT"<br />
<pre>
originalname = The Batman<br />
newname = Batman<br />
produces only "application/json"
responsebody[success] -
{
    "error": false,
    "message": null,
    "data": {
        "_id": "batmanmovie2022",
        "movieName": "Batman",
        "leadActor": "Robert Pattinson",
        "is3D": false
    }
}
responsebody[error if no movie found] -
{
    "error": true,
    "message": "Movie not found with name The Batman",
    "data": null
}
</pre>
<h5><u>Get Movie by name:</u> </h5>
<p><u>Api Details:</u> Rest API to get Movie by name. Name parameter is case-insensitive</p>
URL endpoint - {hostname}/movie/getmoviebyname?moviename={moviename}<br />
http method - "GET"<br />
produces only "application/json"
<pre>
moviename=The Batman</br>
responsebody[success] -
{
    "error": false,
    "message": null,
    "data": {
        "_id": "batmanmovie2022",
        "movieName": "The Batman",
        "leadActor": "Robert Pattinson",
        "is3D": false
    }
}
responsebody[error if no movies found with the given name] -
{
    "error": true,
    "message": "Movie not found with name The Batman",
    "data": null
}
</pre>