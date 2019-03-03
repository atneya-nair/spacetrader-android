package edu.gatech.cs2340.spacetraderredux.Model


class GameInstance(val player: Player, val difficulty: Difficulty) {
    val universe: Universe

    init {
        this.universe = Universe()
    }

}
