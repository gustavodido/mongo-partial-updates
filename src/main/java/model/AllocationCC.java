package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.UUID;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "inSeasonCustomerChoice")
@EqualsAndHashCode
@Slf4j
public class AllocationCC {
    public static final int MODEL_VERSION = 11;

    public static final int DEFAULT_CYCLE_PERIOD = 4;
    public static final int DEFAULT_SAFETY_PERIOD = 4;
    public static final Integer SUBCLASS_LEVEL = 6;
    public static final String SUBCLASS_LEVEL_NAME = "SubClass";

    @Id
    private UUID id;

    @Indexed(unique = true)
    private String plannedCcId;
    private String assortedCcId;
    private String receiptId;

    @Indexed
    private String ccNumber;
    private String description;

    private String brandId;
    private String marketId;
    private String channelId;

    @Transient
    @Setter
    private String marketDescription;

    @Setter
    private boolean active;
    @Setter
    private boolean basic;


    private Collection<Sku> skus;

    @Indexed
    private String styleNumber;
    private String styleDescription;

    private String globalId;
    private String globalAssortedItemId;
    private String globalAssortedCcId;

    private Collection<MerchandiseHierarchy> merchandiseHierarchy;

    private String inStoreStartDate;
    private String seasonCode;

    @Setter
    private int cyclePeriodDays;
    @Setter
    private int safetyPeriodDays;
    private int visMinLifeCycleDays;

    @Setter
    private BigDecimal averagePerStore;
    @Setter
    private BigDecimal promotedAveragePerStore;

    private BigDecimal visualMinMultiplier;
    private Boolean isSizeMinEnforced;
    private String visualMinArbitration;
    @Setter
    private String storeListId;
    @Setter
    private Collection<Distro> distros;
    @Setter
    private Collection<PlannedCC.PlanInput> inSeasonInputs;

    @Setter
    private int modelVersion;
    private String createdBy;
    private LocalDateTime createdTimeStamps;
    @Setter
    private String lastUpdateBy;
    @Setter
    private LocalDateTime lastUpdatedTimeStamps;

    @Setter
    private Long weeksAtRegularPrice;

    @Setter
    private Boolean releaseFlag;

}
