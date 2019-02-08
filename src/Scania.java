import java.awt.*;

public class Scania extends Transporter{

    // Frågor till Niklas
    // Är det rimligt att ha en Vehicle class som man Delegerar till via Composition?
    // Annars hur ska man använda ett builder pattern när man har en Abstract Class?
    // Om vi vill använda gas, så vill vi få ett felmeddelande
    // Problem -> Man kan kringå gas med denna lösningen, om man callar på truck.gas() istället för scania objektets gas, om man inte använder abstract
    // Dock är den privat så man kan inte nå truck i detta fallet.
    // När jag Unloader så kan jag antigen returnera Vehicle via pop, och då blir andra fllet att jag returnerar null, alt en void funktion
    // T.ex. Om jag vill loada en cargo, borde vi casta exceptions för angivet fel. te.x IsFull, OutOfRange, InvalidType etcetc..

    private Vehicle.Type type;
    private Direction direction;
    private Engine engine;
    private Body body;
    private String modelname;
    private Position position;
    private RegularCargo cargo;


    public Scania() {
        this(Color.red);
    }


    public Scania(Color color){
        body = new Body(color, 2);
        engine = new Engine(250);
        type = Vehicle.Type.TRUCK;
        direction = Direction.SOUTH;
        modelname = "Scania";
        position = ITransportable.position;
    }


    public RegularCargo getCargo() {
        return cargo;
    }


    public void raiseCargo(double amount){
        if(!isMoving()){
            cargo.raise(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before raising the cargo");
        }
    }

    public void lowerCargo(double amount){
        if(!isMoving()){
            cargo.lower(amount);
        }
        else{
            throw new IllegalStateException("You need to stop moving before lowering the cargo");
        }
    }

    @Override
    public boolean canBeLoaded() {
        return false;
    }

    @Override
    public boolean unLoadable() {
        return false;
    }

    @Override
    public void unLoad() {

    }

    @Override
    public void load() {

    }
}
