package com.orama.app.dto.transaction;

import com.orama.app.enums.CategoryEnum;
import java.math.BigDecimal;

public record TransactionResponseDTO(
    Long id, BigDecimal amount, String description, CategoryEnum category) {}
