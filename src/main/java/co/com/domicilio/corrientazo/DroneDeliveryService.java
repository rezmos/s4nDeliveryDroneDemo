package co.com.domicilio.corrientazo;

import co.com.domicilio.corrientazo.model.DeliveryAddresses;
import co.com.domicilio.corrientazo.utils.Property;
import co.com.domicilio.corrientazo.utils.ReadProperty;

public class DroneDeliveryService {

    public static void main(String[] args) {

        DeliveryAddresses deliveryAddresses = new DeliveryAddresses();
        deliveryAddresses.loadDeliveryAddresses();

    }

    public static void loadProperties () {
        String droneCapacity = ReadProperty.getProperty(Property.DRONE_CAPACITY);
    }
}
