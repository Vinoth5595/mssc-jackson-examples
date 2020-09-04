package guru.springframework.msscjacksonexamples.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.UUID;

public class BaseTest {
	BeerDto getBeerDto() {
		return BeerDto.builder()
				.beerName("Beer Name 1")
				.beerStyle("Beer Style 1")
				.id(UUID.randomUUID())
				.createdDate(OffsetDateTime.now())
				.lastUpdatedDate(OffsetDateTime.now())
				.price(new BigDecimal(10))
				.upc(1234567L)
				.localDate(LocalDate.now())
				.build();
	}
}
