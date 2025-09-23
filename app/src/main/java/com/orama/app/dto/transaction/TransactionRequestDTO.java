package com.orama.app.dto.transaction;

import com.orama.app.enums.CategoryEnum;
import java.math.BigDecimal;

public record TransactionRequestDTO(String description, BigDecimal amount, CategoryEnum category) {}
