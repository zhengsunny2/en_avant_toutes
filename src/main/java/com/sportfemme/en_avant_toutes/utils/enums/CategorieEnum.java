package com.sportfemme.en_avant_toutes.utils.enums;

public enum CategorieEnum {
    ENTRAINEMENT( "Entrainement"),
    NUTRITION( "Nutrition"),
    DOCUMENTAIRE( "Documentaire");

    
        private final String displayName;
    
        CategorieEnum(String displayName) {
            this.displayName = displayName;
        }
    
        public String getDisplayName() {
            return displayName;
        }

 
    }
    


