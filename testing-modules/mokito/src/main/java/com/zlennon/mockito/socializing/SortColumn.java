package com.zlennon.mockito.socializing;

public enum SortColumn {
	iso, name, printableName, iso3, countryCode;
	
	public static SortColumn find(String name) {
		for(SortColumn col: values()) {
			if(col.name().equalsIgnoreCase(name)) {
				return col;
			}
		}
		
		return null;
	}
}
