package agh.cs.oop

import kotlin.system.exitProcess


fun main(args: Array<String>) {
    val args = "f b r l f f r r f f f f f f f f"
    val directions: Iterable<MoveDirection>
    try{
       directions = OptionsParser.parse(args)
    } catch (e: Exception){
        println(e.message)
        exitProcess(2)
    }
    val map: IWorldMap = GrassField(10)
    val positions = listOf(Vector2d(2, 2), Vector2d(3, 4))

    for (elem in positions) {
        try{
            map.place(Animal(map = map, position = elem))
        }
        catch (e: Exception){
            println(e.message)
        }
    }

    val engine: IEngine = SimulationEngine(directions, map)
    engine.run()
    print(map.toString())
}
