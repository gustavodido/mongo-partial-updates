package model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.util.Collection;

@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Slf4j
public class Distro {

    private static final int PERIOD_ADJUSTMENT = 1;
    private String id;
    private String distroName;
    private LocalDate inStoreStartDate;
    private LocalDate inStoreEndDate;
    private LocalDate markdownDate;
    private Integer visMinLifeCycleDays;
    private Collection<DistributionCenter> distributionCenters;

    @Transient
    private boolean storeListUpdated;
    private String storeListId;
    private Boolean isChangedByUser;
    private boolean active;
    private Boolean releaseFlag;
}
