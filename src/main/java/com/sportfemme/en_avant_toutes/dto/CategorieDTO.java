package com.sportfemme.en_avant_toutes.dto;

import java.util.List;

public interface CategorieDTO {
    Long getId();
    String getName();
    List<SousCategorieDTO> getSousCategories();
}
