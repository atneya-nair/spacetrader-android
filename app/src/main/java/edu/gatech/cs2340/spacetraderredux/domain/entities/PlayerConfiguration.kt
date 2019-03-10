package edu.gatech.cs2340.spacetraderredux.domain.entities

import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SkillType
import javax.inject.Inject

class PlayerConfiguration @Inject constructor(){

    val MAX_SKILLPOINTS = 16
    val DEFAULT_PLAYER_NAME = "Player1"
    val DEFAULT_PLAYER_DIFFICULTY = Difficulty.EASY

    var playerName = DEFAULT_PLAYER_NAME
    var playerDifficulty = DEFAULT_PLAYER_DIFFICULTY
    private var skillPoints = HashMap<SkillType, Int>()
    var remaining = MAX_SKILLPOINTS

    init {
        for (type in SkillType.values()) {
            skillPoints.put(type, 0)
        }
    }

    fun reinitialize() {
        playerDifficulty = DEFAULT_PLAYER_DIFFICULTY
        playerName = DEFAULT_PLAYER_NAME
        skillPoints = HashMap()
        remaining = MAX_SKILLPOINTS

        for (type in SkillType.values()) {
            skillPoints.put(type, 0)
        }
    }

    fun incrementDifficulty() {
        playerDifficulty = Difficulty.values()[(playerDifficulty.ordinal + 1) % Difficulty.values().size]
    }

    fun decrementDifficulty() {
        playerDifficulty = Difficulty.values()[(playerDifficulty.ordinal + Difficulty.values().size - 1) % Difficulty.values().size]
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

    fun isPlayerNameValid(): Boolean {
        return playerName.isNotEmpty() && playerName.length < 20 && !playerName.contains(Regex("^.*[^a-zA-Z0-9 ].*$"))
    }

    fun areSkillPointsRemaining(): Boolean {
        return remaining != 0
    }

    fun isValidConfig(): Boolean {
        return !areSkillPointsRemaining() && isPlayerNameValid()
    }

    fun getSkills(): Skills? {
        if (isValidConfig()) {
            return Skills(getSkillPoints(SkillType.PILOT), getSkillPoints(SkillType.FIGHTER),
                    getSkillPoints(SkillType.TRADER), getSkillPoints(SkillType.ENGINEER))
        }
        return null
    }

    fun getName(): String? {
        if (isValidConfig()) {
            return playerName;
        }
        return null
    }

    fun getDifficulty(): Difficulty? {
        if (isValidConfig()) {
            return playerDifficulty;
        }
        return null
    }
}
