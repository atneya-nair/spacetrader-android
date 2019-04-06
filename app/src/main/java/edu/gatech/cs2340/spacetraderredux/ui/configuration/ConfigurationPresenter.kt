package edu.gatech.cs2340.spacetraderredux.ui.configuration

import edu.gatech.cs2340.spacetraderredux.domain.Game
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.Universe
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerConfiguration
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SkillType
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.Ship
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types.Gnat
import edu.gatech.cs2340.spacetraderredux.domain.usecases.SaveNewGame
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TradeUseCase
import edu.gatech.cs2340.spacetraderredux.ui.common.BasePresenter
import edu.gatech.cs2340.spacetraderredux.ui.tradepane.TradeActivity
import io.reactivex.observers.DisposableSingleObserver
import javax.inject.Inject

class ConfigurationPresenter @Inject constructor(
        val tradeUseCase: TradeUseCase, private val saveNewGameUseCase: SaveNewGame, var playerConfiguration:PlayerConfiguration): BasePresenter<ConfigurationView>() {



    override fun disposeSubscriptions() {
        saveNewGameUseCase.dispose()
    }
    override fun initialise() {
        getView()?.initialiseView()
    }
    fun onPlayerNameChange(name: String) {
        playerConfiguration.playerName = name
    }

    fun onIncrementSkillType(type: SkillType): Boolean {
        val didSucceed = playerConfiguration.incrementSkill(type)
        getView()?.updateSkillPoints(type, playerConfiguration.getSkillPoints(type))
        getView()?.updateRemainingSkillPoints(playerConfiguration.remaining)
        return didSucceed
    }

    fun onDecrementSkillType(type: SkillType): Boolean {
        val didSucceed = playerConfiguration.decrementSkill(type)
        getView()?.updateSkillPoints(type, playerConfiguration.getSkillPoints(type))
        getView()?.updateRemainingSkillPoints(playerConfiguration.remaining)
        return didSucceed
    }

    fun onIncrementDifficulty() {
        playerConfiguration.incrementDifficulty()
        getView()?.updateDifficulty(playerConfiguration.playerDifficulty)
    }

    fun onDecrementDifficulty() {
        playerConfiguration.decrementDifficulty()
        getView()?.updateDifficulty(playerConfiguration.playerDifficulty)
    }

    fun onSubmit() {
        if (!playerConfiguration.isPlayerNameValid()) {
            getView()?.displayInvalidPlayerNameError()
        } else if (playerConfiguration.areSkillPointsRemaining()) {
            getView()?.displaySkillPointsRemainingError()
        } else {
            val universe = Universe() //TODO Figure out a better way to do this
            val game = Game(PlayerState(playerConfiguration.getName()!!,
                    playerConfiguration.getDifficulty()!!, playerConfiguration.getSkills()!!,
                    universe.solarSystems[0], universe.solarSystems[0].planets[0], Gnat(), 1000), universe)
            saveNewGameUseCase.execute(object: DisposableSingleObserver<Int>() {
                override fun onSuccess(t: Int) {
                    getView()?.configurationSuccess()
                }
                override fun onError(e: Throwable) {
                    e.printStackTrace()
                }
            }, game)
        }
    }
}
