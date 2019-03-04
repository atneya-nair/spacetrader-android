package edu.gatech.cs2340.spacetraderredux.Presenters

import dagger.Component
import edu.gatech.cs2340.spacetraderredux.Model.*
import edu.gatech.cs2340.spacetraderredux.Model.configuration.PlayerConfiguration
import javax.inject.Inject

class ConfigurationPresenter constructor(view: View) {
    var view: View = view

    //TODO: Change to injection
    //@Inject
    var playerConfiguration: PlayerConfiguration = PlayerConfiguration.getInstance()

    fun onIncrementSkillType(type: SkillType): Boolean {
        var didSucceed = playerConfiguration.incrementSkill(type)
        view.updateSkillPoints(type, playerConfiguration.getSkillPoints(type))
        view.updateRemainingSkillPoints(playerConfiguration.getRemainingSkillPoints())
        return didSucceed
    }

    fun onDecrementSkillType(type: SkillType): Boolean {
        var didSucceed = playerConfiguration.decrementSkill(type)
        view.updateSkillPoints(type, playerConfiguration.getSkillPoints(type))
        view.updateRemainingSkillPoints(playerConfiguration.getRemainingSkillPoints())
        return didSucceed
    }

    fun onIncrementDifficulty() {
        playerConfiguration.incrementDifficulty()
        view.updateDifficulty(playerConfiguration.getDifficulty())
    }

    fun onDecrementDifficulty() {
        playerConfiguration.decrementDifficulty()
        view.updateDifficulty(playerConfiguration.getDifficulty())
    }

    fun onSubmit() {
        if (!playerConfiguration.isPlayerNameValid()) {
            view.displayInvalidPlayerNameError()
        } else if (playerConfiguration.areSkillPointsRemaining()) {
            view.displaySkillPointsRemainingError()
        } else {
            view.goToNextView()
        }
    }

    interface View {
        fun updateDifficulty(difficulty: Difficulty)
        fun updateSkillPoints(type: SkillType, points: Int)
        fun updateRemainingSkillPoints(remainingSkillPoints: Int)
        fun displayInvalidPlayerNameError()
        fun displaySkillPointsRemainingError()
        fun goToNextView()
    }
}
