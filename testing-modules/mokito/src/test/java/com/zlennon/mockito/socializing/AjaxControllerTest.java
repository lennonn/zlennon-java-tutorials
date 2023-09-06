package com.zlennon.mockito.socializing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AjaxControllerTest {

	@Mock
	HttpServletRequest request;
	@Mock
	CountryDao countryDao;

	AjaxController ajaxController;
	List<Country> countries;

	@Before
	public void setUp() {
		ajaxController = new AjaxController(countryDao);
		countries = new ArrayList<Country>();
		countries.add(create("Argentina", "AR", "32"));
		countries.add(create("USA", "US", "01"));
		countries.add(create("Brazil", "BR", "05"));
		countries.add(create("India", "IN", "91"));
	}


	
	@Test
	public void sorting_asc_on_iso() {
		when(request.getParameter(anyString())).thenReturn("1", "10",
				SortOrder.ASC.name(), SortColumn.iso.name());

		when(countryDao.retrieve(isA(RetrieveCountryRequest.class)))
				.thenAnswer(new SortAnswer());

		JsonDataWrapper<Country> response = ajaxController.retrieve(request);
		assertEquals("AR", response.getRows().get(0).getIso());
		assertEquals("BR", response.getRows().get(1).getIso());
		assertEquals("IN", response.getRows().get(2).getIso());
		assertEquals("US", response.getRows().get(3).getIso());

	}
	
	@Test
	public void sorting_desc_on_iso() {
		when(request.getParameter(anyString())).thenReturn("1", "10",
				SortOrder.DESC.name(), SortColumn.iso.name(),"test");

		when(countryDao.retrieve(isA(RetrieveCountryRequest.class)))
				.thenAnswer(new SortAnswer());

		JsonDataWrapper<Country> response = ajaxController.retrieve(request);
		assertEquals("AR", response.getRows().get(3).getIso());
		assertEquals("BR", response.getRows().get(2).getIso());
		assertEquals("IN", response.getRows().get(1).getIso());
		assertEquals("US", response.getRows().get(0).getIso());

	}
	
	@Test(expected=RuntimeException.class)
	public void exception() {
		when(request.getParameter(anyString())).thenReturn("1", "10",
				SortOrder.DESC.name(), SortColumn.iso.name());

		when(countryDao.retrieve(isA(RetrieveCountryRequest.class))).thenThrow(new RuntimeException("Database failure"));
		ajaxController.retrieve(request);

	}
	
	@Test
	public void retrieves_empty_country_list() throws Exception {
		when(request.getParameter(anyString())).thenReturn("1", "10",
				SortOrder.ASC.name(), SortColumn.iso.name());

		List<Country> countryList = new ArrayList<Country>();
		countryList.add(new Country());

		when(countryDao.retrieve(isA(RetrieveCountryRequest.class)))
				.thenReturn(countryList);

		JsonDataWrapper<Country> response = ajaxController.retrieve(request);
		assertEquals(1, response.getPage());
		assertEquals(1, response.getTotal());
		assertEquals(1, response.getRows().size());

	}

	private Country create(String name, String iso, String coutryCode) {
		Country country = new Country();
		country.setCountryCode(coutryCode);
		country.setIso(iso);
		country.setName(name);
		return country;
	}

	@Test
	public void countryList_sortedBy_ISO_In_asc_order() throws Exception {
		when(request.getParameter(anyString())).thenReturn("1", "10",
				SortOrder.ASC.name(), SortColumn.iso.name());

		Country argentina = new Country();
		argentina.setIso("AR");
		Country india = new Country();
		india.setIso("IN");
		Country usa = new Country();
		usa.setIso("US");

		List<Country> ascCountryList = new ArrayList<Country>();
		ascCountryList.add(argentina);
		ascCountryList.add(india);
		ascCountryList.add(usa);

		when(
				countryDao
						.retrieve(argThat(new SortByISOInAscendingOrderMatcher())))
				.thenReturn(ascCountryList);

		JsonDataWrapper<Country> response = ajaxController.retrieve(request);
		assertEquals(ascCountryList, response.getRows());

		// verify(request, only()).getParameter(anyString());
	}

	@Test
	public void verify_zero_interaction() {
		verifyNoInteractions (request, countryDao);
	}

	@Test
	public void verify_nomore_interaction() {
		request.getParameter("page");
		request.getContextPath();

		verify(request).getParameter(anyString());
		verify(request).getContextPath();
		// this will fail getContextPath() is not verified
		verifyNoMoreInteractions(request);
	}

	@Test
	public void countryList_sortedBy_ISO_In_desc_order() throws Exception {
		when(request.getParameter(anyString())).thenReturn("1", "10",
				SortOrder.DESC.name(), SortColumn.iso.name());

		Country argentina = new Country();
		argentina.setIso("AR");
		Country india = new Country();
		india.setIso("IN");
		Country usa = new Country();
		usa.setIso("US");

		List<Country> descCountryList = new ArrayList<Country>();
		descCountryList.add(usa);
		descCountryList.add(india);
		descCountryList.add(argentina);

		when(countryDao.retrieve(argThat(new SortByISOInDescOrderMatcher())))
				.thenReturn(descCountryList);

		JsonDataWrapper<Country> response = ajaxController.retrieve(request);
		assertEquals(descCountryList, response.getRows());

	}

	class SortAnswer implements Answer<Object> {
		@Override
		public Object answer(InvocationOnMock invocation) throws Throwable {
			RetrieveCountryRequest request = (RetrieveCountryRequest) invocation
					.getArguments()[0];
			final int order = request.getSortOrder().equals(SortOrder.ASC) ? 1
					: -1;
			final SortColumn col = request.getSortname();
			Collections.sort(countries, (arg0, arg1) -> {
				if (SortColumn.countryCode.equals(col))
					return order
							* arg0.getCountryCode().compareTo(
							arg1.getCountryCode());

				if (SortColumn.iso.equals(col))
					return order * arg0.getIso().compareTo(arg1.getIso());

				return order * arg0.getName().compareTo(arg1.getName());
			});

			return countries;
		}
	}

	class SortByISOInAscendingOrderMatcher implements
			ArgumentMatcher<RetrieveCountryRequest> {
		@Override
		public boolean matches(RetrieveCountryRequest request) {
			SortOrder sortOrder =  request.getSortOrder();
			SortColumn col =  request.getSortname();
			return SortOrder.ASC.equals(sortOrder) && SortColumn.iso.equals(col);
		}
	}

	class SortByISOInDescOrderMatcher implements ArgumentMatcher<RetrieveCountryRequest> {
		@Override
		public boolean matches(RetrieveCountryRequest request) {
				SortOrder sortOrder =  request.getSortOrder();
				SortColumn col =  request.getSortname();
				return SortOrder.DESC.equals(sortOrder)
						&& SortColumn.iso.equals(col);
		}
	}

}
