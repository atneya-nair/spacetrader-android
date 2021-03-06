package edu.gatech.cs2340.spacetraderredux.domain.entities

data class Skills(val pilot: Int, val fighter: Int, val trader: Int, val engineer: Int) {
    companion object {
        const val MAX_SKILL = 16
    }
}