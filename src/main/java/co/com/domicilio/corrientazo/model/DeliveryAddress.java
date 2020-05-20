package co.com.domicilio.corrientazo.model;

import co.com.domicilio.corrientazo.model.enums.CardinalPoints;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeliveryAddress {
    private  Point point;

    public DeliveryAddress(){
        this.point = new Point();
    }

    public static DeliveryAddress generateDeliveryAddress(String address, DeliveryAddress currentDeliveryAddress) {
        int x = currentDeliveryAddress.getPoint().getX();
        int y = currentDeliveryAddress.getPoint().getY();
        CardinalPoints currentCardinalPoint = currentDeliveryAddress.getPoint().getCardinalPoints();


        for (int i = 0; i < address.length(); i++) {
            char nextDirectionToken = address.charAt(i);
            if (nextDirectionToken == 'A' ) {
                if (currentCardinalPoint.equals( CardinalPoints.NORTH) ) {
                    y+=1;
                } else if (currentCardinalPoint.equals( CardinalPoints.WEST)) {
                    x-=1;
                } else if (currentCardinalPoint.equals( CardinalPoints.EAST)) {
                    x+=1;
                } if (currentCardinalPoint.equals( CardinalPoints.SOUTH) ) {
                    y-=1;
                }
            } else if ( nextDirectionToken == 'I') {
                if (currentCardinalPoint.equals( CardinalPoints.NORTH)) {
                    currentCardinalPoint = CardinalPoints.WEST;
                } else if (currentCardinalPoint.equals( CardinalPoints.WEST)) {
                    currentCardinalPoint = CardinalPoints.SOUTH;
                } else if (currentCardinalPoint.equals( CardinalPoints.EAST)) {
                    currentCardinalPoint = CardinalPoints.NORTH;
                } else if (currentCardinalPoint.equals( CardinalPoints.SOUTH)) {
                    currentCardinalPoint = CardinalPoints.WEST;
                }
            } else if ( nextDirectionToken == 'D') {
                if (currentCardinalPoint.equals( CardinalPoints.NORTH)) {
                    currentCardinalPoint = CardinalPoints.EAST;
                }  else if (currentCardinalPoint.equals( CardinalPoints.WEST)) {
                    currentCardinalPoint = CardinalPoints.NORTH;
                } else if (currentCardinalPoint.equals( CardinalPoints.EAST)) {
                    currentCardinalPoint = CardinalPoints.SOUTH;
                } else if (currentCardinalPoint.equals( CardinalPoints.SOUTH)) {
                    currentCardinalPoint = CardinalPoints.EAST;
                }
            }
        }
        return new DeliveryAddress(new Point(x, y, currentCardinalPoint));
    }

    @Override
    public String toString(){
        return "("+this.getPoint().getX()+", "+this.getPoint().getY()+") "+this.getPoint().getCardinalPoints().toString().toLowerCase() + " direction";
    }

}
