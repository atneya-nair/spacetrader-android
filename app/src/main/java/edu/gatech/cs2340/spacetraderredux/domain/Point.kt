package edu.gatech.cs2340.spacetraderredux.domain

class Point (val x : Int, val y : Int) {
    override fun equals(other: Any?): Boolean {
        return if (other is Point) {
            this.x == other.x && this.y == other.y
        } else {
            this.x == other && this.y == other
        }
    }

    override fun hashCode(): Int {
        var result = x
        result = 31 * result + y
        return result
    }
}