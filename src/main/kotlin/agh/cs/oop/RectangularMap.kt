package agh.cs.oop


class RectangularMap(private val width: Int, private val height: Int) : AbstractorWorldMap() {
    override val visualizer = MapVisualizer(this)

    override fun canMoveTo(position: Vector2d): Boolean {
        return super.canMoveTo(position)
                && position.x >= 0
                && position.x < width
                && position.y >= 0
                && position.y < height
    }

    override fun toString(): String {
        return visualizer.draw(Vector2d(0, 0), Vector2d(width, height))
    }
}