package co.com.domicilio.corrientazo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import co.com.domicilio.corrientazo.io.FileReader;

import java.io.IOException;
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
       List<String> addressList = FileReader.readFileInList("deliveryAddressFile.txt");
       DeliveryAddress deliveryAddress = new DeliveryAddress();
       for (String address: addressList) {
            deliveryAddress = DeliveryAddress.generateDeliveryAddress(address, deliveryAddress);
            deliveryAddressList.add(deliveryAddress);
       };
    }
}
