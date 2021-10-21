package agh.cs.oop

// Utwórz typ wyliczeniowy MapDirection z czterema kierunkami: NORTH, SOUTH, WEST, EAST, który:
// posiada metodę toString, która dla kierunku EAST zwraca łańcuch Wschód, dla WEST - Zachód, itd.
// posiada metodę next, która dla kierunku EAST zwraca SOUTH (kolejny kierunek zgodnie z ruchem wskazówek zegara), itd.
// posiada metodę previous, która dla kierunku EAST zwraca NORTH (kolejny kierunek zgodnie z ruchem przeciwnym do ruchu wskazówek zegara), itd.
// posiada metodę toUnitVector, która zwraca jednostkowy wektor przemieszczenia typu Vector2d zgodny z orientacją na mapie, tzn. dla NORTH wektor ten powinien mieć wartość (0,1), dla EAST (1,0), itd.

enum class MapDirection(private val realName : String, private val x : Int, private val y : Int) {
    NORTH("Północ",0,1),
    EAST("Wschód",1,0),
    WEST("Zachód", -1,0),
    SOUTH("Południe",0,-1);

    override fun toString(): String {
        return this.realName
    }

    fun next(): MapDirection {
        var ret: MapDirection? = null
        ret = when (this) {
            NORTH -> EAST
            SOUTH -> WEST
            WEST -> NORTH
            EAST -> SOUTH
        }
        return ret
    }

    fun previous(): MapDirection {
        var ret: MapDirection? = null
        ret = when (this) {
            NORTH -> WEST
            SOUTH -> EAST
            WEST -> SOUTH
            EAST -> NORTH
        }
        return ret
    }

    fun toUnitVector(): Vector2d {
        return Vector2d(this.x, this.y)
    }
}
