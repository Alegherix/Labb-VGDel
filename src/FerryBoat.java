public class FerryBoat extends TransportationVehicle{


    public ITransportable unload() {
        return super.unload(getTransported().getFirst(), decideCargoPositionWhenUnloading());
    }

    /**
     * Used to decide what position the cargo should have when unloading
     * @return Position that is at the back of the SemiTruck
     */
    private Position decideCargoPositionWhenUnloading(){
        double xPosition = 0;
        double yPos = 0;

        switch (getDirection()){
            case NORTH:
                xPosition = getPosition().getY() + 1;
                yPos = getPosition().getY();
                break;
            case SOUTH:
                xPosition = getPosition().getY() - 1;
                yPos = getPosition().getY();
                break;
            case EAST:
                yPos = getPosition().getX() + 1;
                xPosition = getPosition().getX();
                break;
            case WEST:
                yPos = getPosition().getX() - 1;
                xPosition = getPosition().getX();
                break;
        }
        return new Position(xPosition, yPos);
    }

}
