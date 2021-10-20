package hu.progmasters.quarterexam;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TownInfoTest {

    private TownInfo townInfo;

    @BeforeEach
    void initTownInfo() {
        townInfo = new TownInfo();
    }

    // 2.
    @Test
    void testGetCurrentMayor() {
        Town town = new Town();
        Mayor mayor = new Mayor("Alexander Fleming", 49);
        town.setCurrentMayor(mayor);
        assertEquals("The mayor is Alexander Fleming.", townInfo.getCurrentMayor(town));

        mayor.setName("Albert Einstein");
        assertEquals("The mayor is Albert Einstein.", townInfo.getCurrentMayor(town));
    }

    // 3.
    @Test
    void testCountLettersInMayorsName() {
        Mayor mayor = new Mayor("Alexander Fleming", 49);
        assertEquals(5, townInfo.countLettersInMayorsName(mayor));
        mayor.setName("Albert Einstein");
        assertEquals(4, townInfo.countLettersInMayorsName(mayor));
    }

    // 4.
    @Test
    void testIsThisTownCrowded() {
        Town town = new Town();
        town.setPopulation(1000);
        town.setArea(20);
        assertEquals("Just fine", townInfo.isThisTownCrowded(town, 60));
        assertEquals("Too many people", townInfo.isThisTownCrowded(town, 40));
    }

    // 5.
    @Test
    void testIsPopulationDivisibleByNumber() {
        Town town = new Town();
        town.setPopulation(1000);
        assertTrue(townInfo.isPopulationDivisibleByNumber(town, 2));
        assertFalse(townInfo.isPopulationDivisibleByNumber(town, 3));
        assertTrue(townInfo.isPopulationDivisibleByNumber(town, 5));
        assertFalse(townInfo.isPopulationDivisibleByNumber(town, 7));
        assertTrue(townInfo.isPopulationDivisibleByNumber(town, 8));
    }

    // 6.
    @Test
    void testGetMayorAgeInfo() {
        Town town = new Town();
        Mayor previousMayor = new Mayor("Albert Einstein", 61);
        Mayor currentMayor = new Mayor("Alexander Fleming", 49);
        town.setPreviousMayor(previousMayor);
        town.setCurrentMayor(currentMayor);
        int[] mayorAgeInfo = townInfo.getMayorAgeInfo(town);
        assertEquals(49, mayorAgeInfo[0]);
        assertEquals(61, mayorAgeInfo[1]);
        assertEquals(12, mayorAgeInfo[2]);

        currentMayor.setAge(77);
        int[] mayorAgeInfo2 = townInfo.getMayorAgeInfo(town);
        assertEquals(77, mayorAgeInfo2[0]);
        assertEquals(61, mayorAgeInfo2[1]);
        assertEquals(16, mayorAgeInfo2[2]);
    }

    // 7.
    @Test
    void testGetSecondName() {
        Mayor mayor = new Mayor("Alexander Fleming", 49);
        assertEquals("Fleming", townInfo.getSecondName(mayor));
        mayor.setName("Albert Einstein");
        assertEquals("Einstein", townInfo.getSecondName(mayor));
    }

    // 6.
    @Test
    void testGetOlderMayor() {
        Town town = new Town();
        Mayor currentMayor = new Mayor("Alexander Fleming", 49);
        Mayor previousMayor = new Mayor("Albert Einstein", 61);
        town.setCurrentMayor(currentMayor);
        town.setPreviousMayor(previousMayor);
        assertEquals(previousMayor, townInfo.getOlderMayor(town));
        previousMayor.setAge(42);
        assertEquals(currentMayor, townInfo.getOlderMayor(town));
    }
}
