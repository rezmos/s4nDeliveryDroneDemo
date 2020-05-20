package co.com.domicilio.corrientazo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import co.com.domicilio.corrientazo.io.FileUtility;

import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
public class DeliveryAddresses {
    private LinkedList<DeliveryAddress> deliveryAddressList;

    public DeliveryAddresses () {
        this.deliveryAddressList = new LinkedList<DeliveryAddress>();
    }

    public void loadDeliveryAddresses() {
       List<String> addressList = FileUtility.readFileInList("addresses.txt");
       DeliveryAddress deliveryAddress = new DeliveryAddress();
       for (String address: addressList) {
            deliveryAddress = DeliveryAddress.generateDeliveryAddress(address, deliveryAddress);
            deliveryAddressList.add(deliveryAddress);
       };
    }

    public List<DeliveryAddress> getDeliveryAddressesLoadingCapacityPerDrone(int droneIndex, int loadingCapacity){
        List<DeliveryAddress> deliveryAddressesSet = new LinkedList<>();
        if (this.deliveryAddressList == null )
            return null;

        for (int i=(droneIndex*loadingCapacity); i<(loadingCapacity*(droneIndex+1)) &&  i<this.deliveryAddressList.size(); i++){
            DeliveryAddress temp = this.deliveryAddressList.get(i);
            deliveryAddressesSet.add(temp);
        }

        return deliveryAddressesSet;

    }
}
