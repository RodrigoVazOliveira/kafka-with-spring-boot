package dev.devaz.data;

import java.util.List;

public record OrderData(Long code, List<ProductData> products) {
}
