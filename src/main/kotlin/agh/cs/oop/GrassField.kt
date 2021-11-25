package agh.cs.oop

import kotlin.math.sqrt
import kotlin.random.Random

class GrassField(private val n: Int) : AbstractorWorldMap() {
    private val grassMap: HashMap<Vector2d, Grass> = hashMapOf()

    override val visualizer: MapVisualizer = MapVisualizer(this)

    init {
        var i = 0
        val maxi = sqrt((10 * n).toDouble()).toInt()
        while (i < n) {
            val vec = Vector2d(Random.nextInt(maxi), Random.nextInt(maxi))
            if (!isOccupied(vec)) {
                i++
                this.grassMap[vec] = Grass(vec)
                mapBoundary.observePosition(Vector2d(0,0), vec)
            }
        }
    }

    override fun isOccupied(position: Vector2d): Boolean {
        return super.isOccupied(position) || this.grassMap.containsKey(position)
    }

    override fun objectAt(position: Vector2d): Any? {
        return super.objectAt(position) ?: this.grassMap[position]
    }

}
