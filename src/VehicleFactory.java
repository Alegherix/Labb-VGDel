public class VehicleFactory {

    static Saab95 createSaab(Position position){
        return new Saab95(position);
    }

    static Volvo240 createVolvo(Position position){
        return new Volvo240(position);
    }

    static Scania createScania(Position position){
        return new Scania(position);
    }

}
