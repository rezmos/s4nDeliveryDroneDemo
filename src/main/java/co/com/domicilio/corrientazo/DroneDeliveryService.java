package co.com.domicilio.corrientazo;

import co.com.domicilio.corrientazo.io.FileUtility;
import co.com.domicilio.corrientazo.model.DeliveryAddress;
import co.com.domicilio.corrientazo.model.DeliveryAddresses;
import co.com.domicilio.corrientazo.model.Drone;
import co.com.domicilio.corrientazo.utils.Property;
import co.com.domicilio.corrientazo.utils.ReadProperty;

import java.util.List;

public class DroneDeliveryService {


    public static void main(String[] args) {
        final int droneCapacity = Integer.parseInt(ReadProperty.getProperty(Property.DRONE_CAPACITY));
        final int droneQuantity = Integer.parseInt(ReadProperty.getProperty(Property.DRONE_CAPACITY));

        FileUtility.purgeReportDirectory();
        DeliveryAddresses deliveryAddresses = new DeliveryAddresses();
        deliveryAddresses.loadDeliveryAddresses();

        for (int i=0; i< droneQuantity; i++){
            Drone drone = new Drone(""+ (i+1));
            List<DeliveryAddress> deliveryAddressListPerDrone =  deliveryAddresses.getDeliveryAddressesLoadingCapacityPerDrone(i, droneCapacity);
            drone.deliver(deliveryAddressListPerDrone);
        }
    }
}
