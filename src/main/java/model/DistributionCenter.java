package model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.util.Collection;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributionCenter {
    private String id;
    private String dcNumber;
    private String dcCode;
    private LocalDate inStoreStartDate;
    private LocalDate inStoreEndDate;
    private LocalDate markdownDate;
    private Integer visMinLifeCycleDays;
    private Integer timeOnOfferDays;
    private Collection<Location> locations;

    @Transient
    private boolean dcMappingUpdated;
    private Boolean releaseFlag;
}
