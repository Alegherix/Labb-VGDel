public interface ITransportable {

    Position position = new Position();

    /**
     * Default method för att sätta Loading range till +-2 i X/Y led, kan även sätta in value, om man hade
     * velat ha större frihet över att bestämma rangen
     * @param position
     * @return
     */

    default boolean withinValidLoadingRange(Position position){
        if(Math.abs(position.getX() - this.position.getX())<=2 &&
                Math.abs(position.getY() - this.position.getY())<=2){
            return true;
        }
        else{
            throw new IllegalArgumentException("The transportable your trying to load is without of range for transportation");
        }
    }

}
