package agh.cs.oop

import java.util.*
import kotlin.Comparator

class Comparator_2<T>(val essa: ArrayList<(T) -> Int>) : Comparator<T> {
    override fun  compare(o1: T, o2: T): Int {
        return if (o1 == o2){
            0
        } else {
            var index = 0
            while (index < essa.size){
                val curr_selector = essa[index]

                if (curr_selector(o1) != curr_selector(o2)){
                    return curr_selector(o1) - curr_selector(o2)
                }

                index += 1
            }
            throw ArithmeticException("Selectors:\n " + essa + " found 2 objects that can't be compared :(, \n" + o1.toString() + " ; \n" + o2.toString())
        }
    }
}

class MapBoundary : IObserver<Vector2d> {

    private val x_selector : (Vector2d) -> Int = {elem -> elem.x}
    private val y_selector : (Vector2d) -> Int = {elem -> elem.y}

    private val x_comp = Comparator_2(arrayListOf(x_selector, y_selector))
    private val y_comp = Comparator_2(arrayListOf(y_selector, x_selector))


    private val sets = arrayListOf(
        TreeSet<Vector2d>(x_comp),
        TreeSet<Vector2d>(y_comp))

    fun lowerLeft(): Vector2d {
        return Vector2d(x_selector(sets[0].pollFirst()?: Vector2d(0,0)), y_selector(sets[1].pollFirst()?:Vector2d(0,0)))
    }

    fun upperRight(): Vector2d {
        return Vector2d(x_selector(sets[0].pollLast()?:Vector2d(0,0)), y_selector(sets[1].pollLast()?:Vector2d(0,0)))
    }



    override fun observePosition(old: Vector2d, new: Vector2d) {
        for (i in 0..1) {
            if (old in sets[i]){
                sets[i].remove(old)
            }
            sets[i].add(new)
        }
    }
}
