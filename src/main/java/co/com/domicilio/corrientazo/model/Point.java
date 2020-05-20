package co.com.domicilio.corrientazo.model;

import co.com.domicilio.corrientazo.model.enums.CardinalPoints;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Point {
    private Integer x;
    private Integer y;
    private CardinalPoints cardinalPoints;

    public Point(){
        this.x = 0;
        this.y = 0;
        this.cardinalPoints = CardinalPoints.NORTH;
    }

    @Override
    public String toString() {
        return "DeliveryAddress ( X: " + this.x + ", Y: " + this.y + ", Cardinal Point: " + this.cardinalPoints.name();
    }
}
