package co.com.domicilio.corrientazo.model;

import lombok.Data;

@Data
public class Drone {
    private Point currentPosition;

    public Drone(){
        this.currentPosition = new Point();
    }
}
