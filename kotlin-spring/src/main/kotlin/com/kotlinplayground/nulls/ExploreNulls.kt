package com.kotlinplayground.nulls

data class Movie(
    val id: Int?,
    val name: String
)

// Handing null
fun main() {
    // ? 사용할 경우만 nullable
    var nameNullable : String? = null
    println("Value is : ${nameNullable?.length}") // safe operator

    nameNullable = "Bryce"
    // val length = nameNullable?.length?.toLong() ?: 0// Elvis operator
    val length = nameNullable.length.toLong()
    println("length : $length")

    val movie = Movie(null, "Avengers")
    val savedMovie = saveMovie(movie)
    println(savedMovie.id!!) // non null assertions !!
    println("Saved Movie : $savedMovie")

}

fun saveMovie(movie: Movie) : Movie {
    // return movie.copy(id = 1)
    return movie
}
