package co.com.domicilio.corrientazo.model;

import co.com.domicilio.corrientazo.io.FileUtility;
import lombok.Data;

import java.util.List;

@Data
public class Drone {
    private Point currentPosition;
    private String name;

    public Drone(String name){
        this.currentPosition = new Point();
        this.name= name;
    }

    public void deliver(List<DeliveryAddress> deliveryAddressListPerDrone) {
        deliveryAddressListPerDrone.stream().forEach(deliveryAddress -> {
            FileUtility.writeFile(name, deliveryAddress.toString());
        });
    }
}
