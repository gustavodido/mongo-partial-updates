package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.mongodb.core.index.Indexed;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Getter
@Setter
@Builder
public class Location {
    public static final BigDecimal DEFAULT_IAF = BigDecimal.ONE;

    private String id;
    private String storeNumber;
    private String storeName;
    private String storeStatus;
    private LocalDate inStoreStartDate;
    private LocalDate inStoreEndDate;
    private LocalDate markdownDate;
    private Integer visMinLifeCycleDays;
    private int visualMinimumUnits;
    private int safetyPeriodDays;
    private BigDecimal inventoryAdjustmentFactor;
    private LocalDate inventoryAdjustmentExpirationDate;
    private boolean replenFlag;
    @Indexed(sparse = true)
    private Boolean releaseFlag;
    private boolean active;

    private LocalDateTime releasedForAllocationTimestamp;
    private LocalDate releaseDate;
}
