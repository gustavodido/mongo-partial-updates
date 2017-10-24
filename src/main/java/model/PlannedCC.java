package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@EqualsAndHashCode
@ToString
public class PlannedCC {
    @Getter
    private String id;
    @Getter
    private AssortedCustomerChoice assortedCustomerChoice;
    @Getter
    private Collection<PlanInput> planInputs;

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode
    @Getter
    @Setter
    @ToString
    public static class AssortedCustomerChoice {
        private String id;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @EqualsAndHashCode
    @Getter
    @Setter
    @ToString
    public static class PlanInput {

        private Period period;
        private long version;
        private DemandProjectionFacts demandProjectionFacts;
        private ReceiptRecommendationFacts receiptRecommendationFacts;
        private DemandWeeklyAdjustmentFacts demandWeeklyAdjustmentFacts;
        private boolean isCurrentVersion;
        private String createdBy;
        private String projectorVersion;
    }

    //region Period - DONE
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class Period {
        public static final FiscalYearWeek BEGINNING_OF_TIME = new FiscalYearWeek(1901, 1);
        public static final FiscalYearWeek END_OF_TIME = new FiscalYearWeek(3000, 52);
        private FiscalYearWeek start;
        private FiscalYearWeek end;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class FiscalYearWeek {
        private Integer fiscalYear;
        private Integer fiscalWeek;
    }
    //endregion

    //region DemandProjectionFacts
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class DemandProjectionFacts { //NOSONAR
        private Integer userDefinedBuyQuantity;
        private Integer weeksAtRegularPrice;
        private BigDecimal averageUnitRetailShave;
        private BigDecimal averagePerStore;
        private Boolean isAveragePerStoreOverridden;
        private BigDecimal regularSellThroughPercent;
        private LocalDate plannedInStoreDate;
        private TicketPrice ticketPrice; // TODO BigMoney
        private PlanFinancialFacts planFinancialFacts;
        private Integer inDistributionCenterToInStoreWindow;
        private SizeProfile sizeProfile;
        private SizeRange sizeRange;
        private Boolean isManuallySized;
        private Boolean isAutoSized;
        private AssortmentStrategy assortmentStrategy;
        private RollingDistro rollingDistro;
        private LocalDate markdownDate;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class TicketPrice {
        private String code;
        private String amount;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class PlanFinancialFacts {
        private AdvancedTicketPrice advancedTicketPrice;
        private ValueAddedTax valueAddedTax;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class AdvancedTicketPrice {
        private String defaultEconomicRegion;
        private Collection<AdvancedTicketPriceEconomicRegions> economicRegions;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class AdvancedTicketPriceEconomicRegions {
        private String name;
        private Collection<AdvancedTicketPriceTimeBasedValues> timeBasedValues;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class AdvancedTicketPriceTimeBasedValues {
        private Period period;
        private AdvancedTicketPriceTimeBasedValuesValue value; // TODO BigMoney
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class AdvancedTicketPriceTimeBasedValuesValue {
        private String code;
        private String amount;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class ValueAddedTax {
        private String category;
        private String defaultEconomicRegion;
        private Collection<ValueAddedTaxEconomicRegions> economicRegions;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class ValueAddedTaxEconomicRegions {
        private String name;
        private Collection<ValueAddedTaxTimeBasedValues> timeBasedValues;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class ValueAddedTaxTimeBasedValues {
        private Period period;
        private BigDecimal value;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class SizeProfile {
        private String id;
        private Boolean isCustom;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class SizeRange {
        private String id;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class AssortmentStrategy {
        private String id;
        private String name;
        private StoreList storeList;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class StoreList {
        private String id;
        private Boolean isTimeBased;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class RollingDistro {
        private Collection<TimeBasedAssortmentStrategy> timeBasedAssortmentStrategies;
        private StoreList storeList;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class TimeBasedAssortmentStrategy {
        private LocalDate startDate;
        private LocalDate endDate;
        private TimeBasedAssortmentStrategyValue value;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @EqualsAndHashCode
    @ToString
    public static class TimeBasedAssortmentStrategyValue {
        private String id;
        private String name;
    }

    //endregion

    //region ReceiptRecommendationFacts - DONE
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class ReceiptRecommendationFacts { //NOSONAR
        private String receiptsRecommendationStrategy;
        private Integer maxNumberOfRecommendedReceipts;
        private String receiptsCadenceStrategy;
        private Integer receiptsCadence;
        private Boolean isOpenStockAllowed;
        private Collection<BuyReceipts> buyReceipts;
        private Boolean buyIntoDemandImpacts;
        private Integer minimumOrderQuantity;
        private Integer bookedQuantity;
        private LocalDate bookingDate;
        private Integer safetyWeeks;
        private Integer initialReceiptSafetyWeeks;
        private Integer weeksAtRegularPriceForOneReceipt;
        private BigDecimal loadPercentage;
        private Integer lastReceiptHorizon;
        private Boolean isUserReceiptLinkedToRecommendedReceipt;
        private Integer roundingIncrement;
        private String minimumBuyRoundingStrategy;
        private BigDecimal receiptNeedRounding;
        private VisualMinimumConfiguration visualMinimumConfiguration;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class BuyReceipts {
        private Integer fiscalYear;
        private Integer fiscalWeek;
        private BigDecimal value;
        private Collection<SizeContributions> sizeContributions;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class SizeContributions {
        private BigDecimal contributionPercent;
        private Size size;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class Size {
        private String id;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class VisualMinimumConfiguration {
        private String rounding;
        private String arbitration;
        private BigDecimal multiplier;
        private Integer numberOfDays;
        private Boolean isOneUnitPerSizeEnforced;
    }
    //endregion

    //region DemandWeeklyAdjustmentFacts - DONE
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class DemandWeeklyAdjustmentFacts {
        private Collection<WeeklyAdjustmentFacts> demandMultipliers;
        private Collection<WeeklyAdjustmentFacts> priceMultipliers;
        private Collection<WeeklyAdjustmentFacts> inventoryRestatement;
        private Collection<PriceEventManagementDiscountPercentages> priceEventManagementDiscountPercentages;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class WeeklyAdjustmentFacts {
        private Integer fiscalYear;
        private Integer fiscalWeek;
        private BigDecimal value;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    @Getter
    @Setter
    @EqualsAndHashCode
    @ToString
    public static class PriceEventManagementDiscountPercentages {
        private Integer fiscalYear;
        private Integer fiscalWeek;
        private BigDecimal value;
        private Collection<String> descriptions;
    }
    //endregion
}
