package agh.cs.oop

fun main(args: Array<String>) {

    var animal1: Animal = Animal()

    OptionsParser.parse("f f b p r o l l r b lk").forEach {
        animal1.move(it)
        println(animal1)
    }

}