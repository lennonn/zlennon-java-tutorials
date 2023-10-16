package com.zlennon.scheduling.quartz.covid;

import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "covid")
@Data
public class Covid {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private String id;
    @CsvBindByName(column = "FIPS")
    private Integer fips;
    @CsvBindByName(column = "Admin2")
    private String admin2;
    @CsvBindByName(column = "Province_State")
    private String provinceState;
    @CsvBindByName(column = "Country_Region")
    private String countryRegion;
    //@CsvDate("yyyy/MM/dd HH:mm:ss")
    @CsvBindByName(column = "Last_Update")
    private String lastUpdate;
    @CsvBindByName(column = "Lat")
    private Double lat;
    @CsvBindByName(column = "Long_")
    private Double long_;
    @CsvBindByName(column = "Confirmed")
    private Integer confirmed;
    @CsvBindByName(column = "Deaths")
    private Integer deaths;
    @CsvBindByName(column = "Recovered")
    private Integer recovered;
    @CsvBindByName(column = "Active")
    private Integer active;
    @CsvBindByName(column = "Combined_Key")
    private String combinedKey;
    @CsvBindByName(column = "Incident_Rate")
    private Double incidentRate;
    @CsvBindByName(column = "Case_Fatality_Ratio")
    private Double caseFatalityRatio;
    private LocalDate confirmedDate;

}
