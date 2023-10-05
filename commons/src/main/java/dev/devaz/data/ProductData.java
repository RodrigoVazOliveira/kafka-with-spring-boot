package dev.devaz.data;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public record ProductData(Long code, String name, @JsonFormat(shape = JsonFormat.Shape.STRING) BigDecimal price) {
}
