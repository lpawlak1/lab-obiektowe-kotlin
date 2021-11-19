package agh.cs.oop

/**
 * Interface for observing change on [T] value type
 */
interface IObserver<T> {
    /**
     * Can be used in delegated properties as observer,
     * Takes [old] and [new] values of type [T] and returns [Unit]
     */
    fun observePosition(old: T, new: T)
}
