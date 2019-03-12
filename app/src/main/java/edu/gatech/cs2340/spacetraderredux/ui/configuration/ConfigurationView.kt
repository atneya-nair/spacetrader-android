package edu.gatech.cs2340.spacetraderredux.ui.configuration

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SkillType

interface ConfigurationView {
    fun initialiseView()
    fun updateDifficulty(difficulty: Difficulty)
    fun updateSkillPoints(type: SkillType, points: Int)
    fun updateRemainingSkillPoints(remainingSkillPoints: Int)
    fun displayInvalidPlayerNameError()
    fun displaySkillPointsRemainingError()
    fun configurationSuccess(game: Game)
}