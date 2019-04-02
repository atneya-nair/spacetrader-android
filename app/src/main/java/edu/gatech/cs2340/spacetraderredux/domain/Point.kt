package edu.gatech.cs2340.spacetraderredux.domain

class Point (val locationX : Int, val locationY : Int) {
    val x : Int
    val y : Int
    init {
        x = locationX
        y = locationY
    }

    override fun equals(other: Any?): Boolean {
        if (other is Point) {
            return this.x.equals(other.x) && this.y.equals(other.y)
        } else {
            return this.x.equals(other) && this.y.equals(other)
        }
    }
}