package agh.cs.oop

import kotlin.math.sqrt
import kotlin.random.Random

class GrassField(private val n: Int) : AbstractorWorldMap() {
    override val visualizer: MapVisualizer = MapVisualizer(this)

    init {
        var i = 0
        val maxi = sqrt((10 * n).toDouble()).toInt()
        while (i < n) {
            val vec = Vector2d(Random.nextInt(maxi), Random.nextInt(maxi))
            if (!isOccupied(vec)) {
                i++
                super.objectList.add(Grass(vec))
            }
        }
    }

    override fun objectAt(position: Vector2d): Any? {
        return objectList.firstOrNull { it.position == position && it.javaClass == Animal::class.java}
            ?: objectList.firstOrNull { it.position == position}
    }

}