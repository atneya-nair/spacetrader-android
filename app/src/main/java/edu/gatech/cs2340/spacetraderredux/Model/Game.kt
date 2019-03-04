package edu.gatech.cs2340.spacetraderredux.Model


class Game private constructor(){
    val player: Player
    val universe: Universe

    init {
        this.player = Player()
        this.universe = Universe()
    }

    companion object {
        var instance: Game = Game()
            private set

        fun reinitialize() {
            instance = Game()
        }
    }
}
