package edu.gatech.cs2340.spacetraderredux.ui.configuration

import edu.gatech.cs2340.spacetraderredux.di.DaggerPlayerConfigurationComponent
import edu.gatech.cs2340.spacetraderredux.di.SpaceTraderGlobal
import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.Player
import edu.gatech.cs2340.spacetraderredux.domain.Universe
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerConfiguration
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SkillType
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types.Gnat
import javax.inject.Inject

class ConfigurationPresenter constructor(view: ConfigurationView) {


    var view: ConfigurationView = view

    init {
        DaggerPlayerConfigurationComponent.builder().build().inject(this)
    }

    @Inject
    lateinit var playerConfiguration:PlayerConfiguration

    @Inject
    lateinit var universe: Universe

    fun onPlayerNameChange(name: String) {
        playerConfiguration.playerName = name
    }

    fun onIncrementSkillType(type: SkillType): Boolean {
        var didSucceed = playerConfiguration.incrementSkill(type)
        view.updateSkillPoints(type, playerConfiguration.getSkillPoints(type))
        view.updateRemainingSkillPoints(playerConfiguration.remaining)
        return didSucceed
    }

    fun onDecrementSkillType(type: SkillType): Boolean {
        var didSucceed = playerConfiguration.decrementSkill(type)
        view.updateSkillPoints(type, playerConfiguration.getSkillPoints(type))
        view.updateRemainingSkillPoints(playerConfiguration.remaining)
        return didSucceed
    }

    fun onIncrementDifficulty() {
        playerConfiguration.incrementDifficulty()
        view.updateDifficulty(playerConfiguration.playerDifficulty)
    }

    fun onDecrementDifficulty() {
        playerConfiguration.decrementDifficulty()
        view.updateDifficulty(playerConfiguration.playerDifficulty)
    }

    fun onSubmit() {
        if (!playerConfiguration.isPlayerNameValid()) {
            view.displayInvalidPlayerNameError()
        } else if (playerConfiguration.areSkillPointsRemaining()) {
            view.displaySkillPointsRemainingError()
        } else {
            var game = Game(Player(playerConfiguration.getName()!!,
                    playerConfiguration.getDifficulty()!!, playerConfiguration.getSkills()!!,
                    universe.solarSystems[0].planets[0], Gnat(), 1000), universe)
            view.configurationSuccess(game)
        }
    }
}
