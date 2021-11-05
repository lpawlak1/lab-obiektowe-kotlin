package agh.cs.oop

enum class MapDirection {
    NORTH{
        override fun toUnitVector(): Vector2d = Vector2d(0,1)
        override fun toString(): String = "^"
        override fun next(): MapDirection = EAST
        override fun previous(): MapDirection = WEST
    },
    EAST{
        override fun toUnitVector(): Vector2d = Vector2d(1,0)
        override fun toString(): String = ">"
        override fun next(): MapDirection = SOUTH
        override fun previous(): MapDirection = NORTH
    },
    SOUTH{
        override fun toUnitVector(): Vector2d = Vector2d(0,-1)
        override fun toString(): String = "v"
        override fun next(): MapDirection = WEST
        override fun previous(): MapDirection = EAST
    },
    WEST{
        override fun toUnitVector(): Vector2d = Vector2d(-1,0)
        override fun toString(): String = "<"
        override fun next(): MapDirection = NORTH
        override fun previous(): MapDirection = SOUTH
    };

    abstract fun next(): MapDirection
    abstract fun previous(): MapDirection
    abstract fun toUnitVector(): Vector2d
}
