package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

import java.util.Collection;

@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Sku {
    private String id;
    private String skuNumber;
    private String description;
    @Singular
    private Collection<Location> locations;

    @Data
    @Builder(toBuilder = true)
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Location {
        private String id;
        private Integer visualMinimumUnits;
        private Integer sizeMin;
        private double sizeProfilePercentage;

        public Location withVisualMinimumUnits(int visualMinimumUnits) {
            return toBuilder().visualMinimumUnits(visualMinimumUnits).build();
        }
    }
}
