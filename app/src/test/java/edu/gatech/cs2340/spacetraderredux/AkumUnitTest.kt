package edu.gatech.cs2340.spacetraderredux

import edu.gatech.cs2340.spacetraderredux.domain.Point
import edu.gatech.cs2340.spacetraderredux.domain.SolarSystem
import edu.gatech.cs2340.spacetraderredux.domain.Universe
import org.junit.Assert.*
import org.junit.Test

class AkumUnitTest {
    private var point1 : Point
    private var point2 : Point
    private var point3 : Point
    private var point4 : Point
    private var point5 : Object
    private var list : ArrayList<Point>

    init {
        point1 = Point(1, 2)
        point2 = Point(1, 2)
        point3 = Point(1, 2)
        point4 = Point(1, 3)
        point5 = Object()
        list = ArrayList<Point>()
        list.add(point1)
        list.add(point2)
        list.add(point3)
        list.add(point4)


    }

    @Test
    fun testReflexive() {
        assertTrue(point1.equals(point1))
        assertTrue(point2.equals(point2))
        assertTrue(point3.equals(point3))
        assertTrue(point4.equals(point4))

    }

    @Test
    fun testSymmetric() {
        for(i in list){
            for(j in list){
                if(i.equals(j)){
                    assertTrue(j.equals(i))
                } else {
                    assertFalse(j.equals(i))
                }
            }
        }
    }

    @Test
    fun testTransitive() {
        assertTrue(point1.equals(point2))
        assertTrue(point2.equals(point3))
        assertTrue(point1.equals(point3))


    }

    @Test
    fun testConsistency() {
        assertTrue(point1.equals(point2))
        assertTrue(point1.equals(point2))

    }

    @Test
    fun testConsistencyWithModification() {
        assertTrue(point1.equals(point2))
        point1 = Point(2, 3)
        assertFalse(point1.equals(point2))

    }

    @Test
    fun testNotEqualsNull() {
        assertFalse(point5.equals(null))

    }

    @Test
    fun testNotEqualsObject() {
        assertFalse(point1.equals(point5))

    }

    @Test
    fun testHashCodeEqualsConsistency(){
        for(i in list){
            for(j in list){
                if(i.equals(j)){
                    assertTrue(j.hashCode() == i.hashCode())
                } else {

                }
            }
        }
    }

    @Test
    fun testHashCodeInternalConsistency(){
        for(i in list){
            assertTrue(i.hashCode() == i.hashCode())
        }

    }
}