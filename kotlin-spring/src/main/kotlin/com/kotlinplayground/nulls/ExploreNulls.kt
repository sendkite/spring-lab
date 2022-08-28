package com.kotlinplayground.nulls

data class Movie(
    val id: Int?,
    val name: String
)

// Handing null
fun main() {
    // ? 사용할 경우만 nullable
    var nameNullable : String? = null
    println(nameNullable)

    nameNullable = "Bryce"
    println(nameNullable)

    val movie = Movie(null, "Avengers")
    val savedMovie = saveMovie(movie)
    println("Saved Movie : $savedMovie")

}

fun saveMovie(movie: Movie) : Movie {
    return movie.copy(id = 1)
}
