package com.ygseol.helath.healthapplication.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_drug_info")
public class dInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonProperty("HELT_ITM_GRP_CD")
    private String HELT_ITM_GRP_CD;
    @JsonProperty("HELT_ITM_GRP_NM")
    private String HELT_ITM_GRP_NM;
    @JsonProperty("LCLAS_CD")
    private String LCLAS_CD;
    @JsonProperty("LCLAS_NM")
    private String LCLAS_NM;
    @JsonProperty("MLSFC_CD")
    private String MLSFC_CD;
    @JsonProperty("MLSFC_NM")
    private String MLSFC_NM;
    @JsonProperty("SCLAS_CD")
    private String SCLAS_CD;
    @JsonProperty("SCLAS_NM")
    private String SCLAS_NM;

}
