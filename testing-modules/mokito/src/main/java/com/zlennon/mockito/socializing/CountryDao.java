package com.zlennon.mockito.socializing;

import java.util.List;

public interface CountryDao {

	List<Country> retrieve(RetrieveCountryRequest command);
}
