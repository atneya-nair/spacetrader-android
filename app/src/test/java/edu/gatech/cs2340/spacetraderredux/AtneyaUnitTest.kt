package edu.gatech.cs2340.spacetraderredux

import edu.gatech.cs2340.spacetraderredux.domain.*
import edu.gatech.cs2340.spacetraderredux.domain.common.GameStateRepository
import edu.gatech.cs2340.spacetraderredux.domain.entities.PlayerState
import edu.gatech.cs2340.spacetraderredux.domain.entities.Skills
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.Difficulty
import edu.gatech.cs2340.spacetraderredux.domain.entities.enums.SolarSystemName
import edu.gatech.cs2340.spacetraderredux.domain.entities.ship.types.Gnat
import edu.gatech.cs2340.spacetraderredux.domain.usecases.TravelUseCase
import io.reactivex.Scheduler
import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.mock
import java.lang.IllegalStateException
import java.util.Random

class AtneyaUnitTest {

    lateinit var curSystem: SolarSystem
    lateinit var curPlanet: Planet
    lateinit var playerState: PlayerState
    lateinit var game: Game
    lateinit var testSystemFar: SolarSystem
    lateinit var testSystemClose: SolarSystem
    val travelUseCase = TravelUseCase(mock(GameStateRepository::class.java),
            mock(Scheduler::class.java), mock(Scheduler::class.java))
    @Before
    fun setup() {
        curSystem = SolarSystem(SolarSystemName.ACAMAR, Point(10, 10), Random(1))
        curPlanet = curSystem.planets[0]
        playerState = PlayerState("Player1", Difficulty.EASY,
                Skills(16,0,0,0),
                curSystem, curPlanet, Gnat(), 1000)
        game = Game(playerState, Universe())
        testSystemFar = SolarSystem(SolarSystemName.SOL, Point(50, 50), Random())
        testSystemClose = SolarSystem(SolarSystemName.ADAHN, Point(15, 15), Random())
    }

    @Test(expected = IllegalStateException::class)
    fun testOutOfRange() {
        setup()
        try {
            travelUseCase.transform(game, testSystemFar)
        } catch(e: Exception) {
            assertEquals(game.playerState.currSystem, curSystem)
            throw(e)
        }

    }

    @Test
    fun testInRange() {
        setup()
        game = travelUseCase.transform(game, testSystemClose)
        assertEquals(game.playerState.currSystem, testSystemClose)
        assertEquals(game.playerState.ship.storageUnits.fuelTank.current, 14 - 3)
    }
    
}