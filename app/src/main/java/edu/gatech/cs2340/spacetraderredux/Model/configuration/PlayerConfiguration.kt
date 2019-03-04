package edu.gatech.cs2340.spacetraderredux.Model.configuration

import dagger.Module
import dagger.Provides
import edu.gatech.cs2340.spacetraderredux.Model.Difficulty
import edu.gatech.cs2340.spacetraderredux.Model.SkillType
import javax.inject.Singleton

@Module
class PlayerConfiguration private constructor() {
    @Module
    companion object {
        private val MAX_SKILLPOINTS = 16
        private val DEFAULT_PLAYER_NAME = "Player1"
        private val DEFAULT_PLAYER_DIFFICULTY = Difficulty.EASY
        private val configuration = PlayerConfiguration()

        @JvmStatic
        @Provides
        @Singleton
        fun getInstance(): PlayerConfiguration {
            return configuration
        }
    }

    private var difficulty = DEFAULT_PLAYER_DIFFICULTY
    private var playername = DEFAULT_PLAYER_NAME
    private var skillPoints = HashMap<SkillType, Int>()
    private var remaining = MAX_SKILLPOINTS

    init {
        for (type in SkillType.values()) {
            skillPoints.put(type, 0)
        }
    }

    fun reinitialize() {
        difficulty = DEFAULT_PLAYER_DIFFICULTY
        playername = DEFAULT_PLAYER_NAME
        skillPoints = HashMap()
        remaining = MAX_SKILLPOINTS

        for (type in SkillType.values()) {
            skillPoints.put(type, 0)
        }
    }

    fun incrementDifficulty() {
        difficulty = Difficulty.values()[(difficulty.ordinal + 1) % Difficulty.values().size]
    }

    fun decrementDifficulty() {
        difficulty = Difficulty.values()[(difficulty.ordinal + Difficulty.values().size - 1) % Difficulty.values().size]
    }

    fun getDifficulty(): Difficulty {
        return difficulty
    }

    fun incrementSkill(type: SkillType): Boolean {
        if (remaining > 0) {
            skillPoints.put(type, skillPoints.get(type)!! + 1)
            remaining--
            return true
        }
        return false
    }

    fun decrementSkill(type: SkillType): Boolean {
        var pointsAllocated = skillPoints.get(type)!!
        if (pointsAllocated > 0) {
            skillPoints.put(type, pointsAllocated - 1)
            remaining++
            return true
        }
        return false
    }

    fun getSkillPoints(type: SkillType): Int {
        return skillPoints.get(type)!!
    }

    fun getRemainingSkillPoints(): Int {
        return remaining
    }

    fun getName(): String {
        return playername
    }

    fun setName(newName: String) {
        playername = newName
    }

    fun isPlayerNameValid(): Boolean {
        return playername.length > 0
    }

    fun areSkillPointsRemaining(): Boolean {
        return remaining != 0
    }
}
