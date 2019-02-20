import org.junit.Test;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.Assert.*;

public class CarTest {

/*
    @Test
    public void getNrDoors() {
        Vehicle testVolvo = new Volvo240();
        Vehicle testSaab = new Saab95();
        assertEquals(4, testVolvo.getBody().getNrDoors());
        assertEquals(2, testSaab.getBody().getNrDoors());
    }

    @Test
    public void maxSpeedVolvo(){
        Vehicle testVolvo = new Volvo240();
        for(int i =0; i<= testVolvo.getEngine().getEnginePower(); i++){
            testVolvo.gas(1);
        }
        assertEquals(testVolvo.getEngine().getCurrentSpeed(), testVolvo.getEngine().getEnginePower(), 0);
    }

    @Test
    public void maxSpeedSaab(){
        Vehicle testSaab = new Saab95();
        for (int i = 0; i < testSaab.getEngine().getEnginePower(); i++) {
            testSaab.gas(1);
        }
        assertEquals(testSaab.getEngine().enginePower, testSaab.getEngine().getEnginePower(), 0);
    }


    @Test
    public void testBrakesDoesntGoBelowZero(){
        Vehicle testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.getEngine().currentSpeed = testSpeed;
        for (int i = 0; i <= testSpeed+1; i++) {
            testVolvo.brake(1);
        }
        assertEquals(0, testVolvo.getEngine().getCurrentSpeed(),0);
    }

    @Test
    public void testBrakeLowersSpeed(){
        Vehicle testVolvo = new Volvo240();
        int testSpeed = 50;
        testVolvo.getEngine().currentSpeed = testSpeed;
        testVolvo.brake(1);
        assertTrue(testSpeed>testVolvo.getEngine().getCurrentSpeed());
    }


    @Test
    public void colorTest(){
        Vehicle testSaab = new Saab95();
        assertEquals(Color.black, testSaab.getBody().getColor());

        Vehicle coloredSaab = new Saab95(Color.RED);
        assertEquals(Color.red, coloredSaab.getBody().getColor());
    }


    @Test
    public void testCarMovement(){
        Vehicle testCar = new Saab95();
        int randomNumber = ThreadLocalRandom.current().nextInt();
        testCar.getEngine().setCurrentSpeed(randomNumber);
        testCar.move();
        assertEquals(randomNumber, testCar.getPosition().getY(),0);
    }

    @Test
    public void testCarLeftTurnDirection(){
        Vehicle testCar = new Volvo240();
        List<Direction> directionList = Arrays.asList(Direction.EAST, Direction.NORTH, Direction.WEST, Direction.SOUTH);
        for (int i = 0; i < directionList.size(); i++) {
            testCar.turnLeft();
            assertTrue(directionList.get(i).equals(testCar.getDirection()));
        }
    }
/*
    @Test
    public void testFILO(){
        CarCargo carCargo = new CarCargo();
        carCargo.cars.push(new Volvo240());
        carCargo.cars.push(new Saab95(Color.CYAN));
        carCargo.cars.push(new Saab95(Color.YELLOW));
        System.out.println(carCargo.cars.pop().getColor());
    }
*/

/*
    @Test
    public void testScaniaColor(){
        Scania scania = new Scania(Color.CYAN);
        assertTrue(scania.getBody().getColor().equals(Color.CYAN));
    }

    @Test
    public void raiseCargoWhileDriving(){
        Scania scania = new Scania();
        scania.getEngine().startEngine();
        scania.gas(1);
        scania.raiseCargo(50);
        //scania.gas(1);
        //System.out.println(scania.getEngine().getCurrentSpeed());
    }

    @Test
    public void lowerCargoWhileDriving(){
        Scania scania = new Scania();
        scania.getEngine().startEngine();
        scania.lowerCargo(20);
    }
    */

    @Test
    public void maximumCargoAngle(){
        Scania scania = new Scania(Color.CYAN, 100);
        scania.manuallyRaise(150);
        assertEquals(scania.getMaximumAngleCap(), scania.getCargoAngle(),0);
    }

    @Test
    public void minimumCargoAngle(){
        Scania scania = new Scania();
        scania.lowerCargo(55);
        assertEquals(70-55, scania.getCargoAngle(),0);
        scania.lowerCargo(50);
        assertEquals(0,scania.getCargoAngle(),0);
    }


    @Test
    public void engineTest(){
        Saab95 saab95 = new Saab95();
        saab95.gas(1);
        System.out.println(saab95.getEngine().getCurrentSpeed());
    }

    @Test
    public void angleTest(){
        Cargo cargo = new Cargo(100);
        System.out.println(cargo.getAngle().getAmount());

        Scania scania = new Scania();
        scania.lowerCargo(120);
        assertEquals(0, scania.getCargoAngle(),0);

    }

    @Test
    public void depositCarsToGeneralShop(){
        StandardBodyShop standardBodyShop = new StandardBodyShop();
        standardBodyShop.addVehicleToShop(new Saab95());        // -- Allows for Vehicle of multiple types to be added.
        standardBodyShop.addVehicleToShop(new Volvo240());

        Vehicle volvo = standardBodyShop.removeFromBodyShop();
        assertTrue(volvo.getClass().equals(Volvo240.class));
    }

    @Test
    public void depositCarToSpecializedShop(){
        BodyShop<Volvo240> volvo240BodyShop = new BodyShop<>();
        volvo240BodyShop.addVehicleToShop(new Volvo240());
        //volvo240BodyShop.addVehicleToShop(new Saab95());      -- Gives Static Compile time error as Expected.

        BodyShop<Saab95> saab95BodyShop = new BodyShop<>();
        saab95BodyShop.removeFromBodyShop();
    }

    @Test
    public void depositOverLimit(){
        BodyShop<Saab95> volvo240BodyShop = new BodyShop<>();
        for (int i = 0; i <= 11; i++) {
            volvo240BodyShop.addVehicleToShop(new Saab95());
        }

        StandardBodyShop standardBodyShop = new StandardBodyShop();
        for (int i = 0; i <= 5; i++) {
            standardBodyShop.addVehicleToShop(new Volvo240());
            standardBodyShop.addVehicleToShop(new Saab95());
        }

    }

    @Test
    public void RunningScaniaWithCargoDown(){
        Scania scania = new Scania();

        scania.manuallyRaise(110);
        assertEquals(70,scania.getCargoAngle(),0);

        scania.lowerCargo(80);
        assertEquals(0,scania.getCargoAngle(),0);

        scania.manuallyRaise(1);
        scania.move();
    }

    @Test
    public void ferryLoadingProperly(){
        FerryBoat ferryBoat = new FerryBoat();
        ferryBoat.lowerCargo();
        ferryBoat.getEngine().stopEngine();

        Volvo240 carToGetOut = new Volvo240();
        ferryBoat.load(carToGetOut);
        ferryBoat.load(new Saab95());

        assertEquals(2,ferryBoat.getTransported().size());
        assertEquals(carToGetOut, ferryBoat.unload());
    }



    @Test
    public void addingToCargoOverThecap(){
        Semitruck semiTruck = new Semitruck(20);
        semiTruck.lowerCargo();
        semiTruck.getEngine().stopEngine();
        for (int i = 0; i <= 21; i++) {
            semiTruck.load(new Saab95());
        }

    }

    @Test
    public void loadingTransporterWhileMoving(){
        Semitruck semiTruckWithExtension = new Semitruck(20);
        semiTruckWithExtension.getEngine().startEngine();
        semiTruckWithExtension.lowerCargo();
        semiTruckWithExtension.load(new Volvo240());
    }

    @Test
    public void tryingToLoadItself(){
        Semitruck semi = new Semitruck(20);
        semi.lowerCargo();
        semi.load(new Saab95());
        semi.load(semi);
    }

    @Test
    public void lowerCargoWhileDriving(){
        Semitruck semi = new Semitruck(10);
        semi.getEngine().startEngine();
        semi.lowerCargo();
    }

    @Test
    public void pointTest(){
        Point p = new Point(0,80);
        System.out.println(p);
    }

    @Test
    public void scaniaTest(){
        Scania scania = new Scania();
        System.out.println(scania.getMaximumAngleCap());
        System.out.println(scania.getCargoAngle());
        scania.move();
    }

    @Test
    public void carPosition(){
        Saab95 saab95 = new Saab95();
        System.out.println(saab95.getPosition());
        saab95.setPosition(0,50);
        System.out.println(saab95.getPosition());
        saab95.gas(1);
        saab95.move();
        System.out.println(saab95.getPosition());

    }

}