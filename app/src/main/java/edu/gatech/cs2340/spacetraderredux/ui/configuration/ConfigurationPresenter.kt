package edu.gatech.cs2340.spacetraderredux.ui.configuration

import edu.gatech.cs2340.spacetraderredux.di.DaggerPlayerComponent
import edu.gatech.cs2340.spacetraderredux.domain.Player
import edu.gatech.cs2340.spacetraderredux.domain.entities.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerConfiguration
import edu.gatech.cs2340.spacetraderredux.domain.entities.SkillType
import javax.inject.Inject

class ConfigurationPresenter constructor(view: ConfigurationView) {


    var view: ConfigurationView = view


    var playerConfiguration = PlayerConfiguration()

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
            view.configurationSuccess()
            var mPlayer = DaggerPlayerComponent.builder().playerConfig(playerConfiguration).build().player()
            var s = mPlayer.toString()
        }
    }
}
