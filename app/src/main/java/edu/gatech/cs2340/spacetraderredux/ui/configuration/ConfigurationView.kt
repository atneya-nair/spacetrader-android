package edu.gatech.cs2340.spacetraderredux.ui.configuration

import edu.gatech.cs2340.spacetraderredux.domain.entities.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.SkillType

interface ConfigurationView {
    fun updateDifficulty(difficulty: Difficulty)
    fun updateSkillPoints(type: SkillType, points: Int)
    fun updateRemainingSkillPoints(remainingSkillPoints: Int)
    fun displayInvalidPlayerNameError()
    fun displaySkillPointsRemainingError()
    fun configurationSuccess()
}