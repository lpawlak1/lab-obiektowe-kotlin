package agh.cs.oop


fun main(args: Array<String>) {
    val args = "f b r l f f r r f f f f f f f f"
    val directions: Iterable<MoveDirection> = OptionsParser.parse(args)
    val map: IWorldMap = RectangularMap(10, 5)
    val positions = listOf(Vector2d(2, 2), Vector2d(3, 4))

    for (elem in positions) {
        map.place(Animal(map = map, position = elem))
    }

    val engine: IEngine = SimulationEngine(directions, map)
    engine.run()
    print(map.toString())
}