package com.zlennon.redis;

import com.zlennon.redis.item.Item;
import com.zlennon.redis.item.ItemRepository;
import com.zlennon.redis.item.ItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
class SpringRedisApplicationTests {

	@Autowired
	 private ItemService itemService;

	@Autowired
	private CacheManager cacheManager;

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemRepository mockItemRepository;

	private static final String AN_ID = "id-1";
	private static final String A_DESCRIPTION = "an item";
	Item anItem = new Item(AN_ID, "10 minite");
	Item customItem = new Item("custom", "5 minite");
	Item cacheManagerItem = new Item("useCacheManager", "60 minite");


	@Test
	void givenRedisCaching_whenFindItemById_thenItemReturnedFromCache() {
		given(mockItemRepository.findById(AN_ID))
				.willReturn(Optional.of(anItem));

		Item itemCacheMiss = itemService.getItemForId(AN_ID);
		Item itemCacheHit = itemService.getItemForId(AN_ID);

		assertThat(itemCacheMiss).isEqualTo(anItem);
		assertThat(itemCacheHit).isEqualTo(anItem);

		verify(mockItemRepository, times(1)).findById(AN_ID);
		assertThat(itemFromCache()).isEqualTo(anItem);

		//custom
		given(mockItemRepository.findById("custom"))
				.willReturn(Optional.of(customItem));

		Item customItem0 = itemService.getCustomItem("custom");
		Item customItem1 = itemService.getCustomItem("custom");
		Item customItem2 = itemService.getCustomItem("custom");
		Item customItem3 = itemService.getCustomItem("custom");
		verify(mockItemRepository, times(1)).findById("custom");
		assertThat(customerCache()).isEqualTo(customItem);


	}


	@Test
	void givenRedisCaching_useCacheManager() {
		//custom
		given(mockItemRepository.findById("useCacheManager"))
				.willReturn(Optional.of(cacheManagerItem));

		Item customItem0 = itemService.cacheUseCacheManager("useCacheManager");
		Item customItem1 = itemService.cacheUseCacheManager("useCacheManager");
		verify(mockItemRepository, times(1)).findById("useCacheManager");
		assertThat(useCacheManager()).isEqualTo(cacheManagerItem);


	}


	@Test
	@DisplayName("When all items requested then request is successful")
	void whenAllItemsRequested_thenRequestIsSuccessful() throws Exception {
		when(mockItemRepository.findAll()).thenReturn(List.of(anItem,customItem,cacheManagerItem));
		mockMvc
				.perform(get("/item/findAll"))
				.andExpect(status().isOk());
	}

	@Test
	@DisplayName("When all items are requested then they correct number of Items is returned")
	void whenAllItemsRequested_thenReturnAllItems() throws Exception {

		when(mockItemRepository.findAll()).thenReturn(List.of(anItem,customItem,cacheManagerItem));
		mockMvc
				.perform(get("/item/findAll"))
				.andExpect(jsonPath("$", hasSize((int) mockItemRepository.findAll().stream().count())));
	}


	private Object itemFromCache() {
		return cacheManager.getCache("itemCache").get(AN_ID).get();
	}

	private Object customerCache() {
		return cacheManager.getCache("customerCache").get("custom").get();
	}

	private Object useCacheManager() {
		return cacheManager.getCache("useCacheManager").get("useCacheManager").get();
	}

}
