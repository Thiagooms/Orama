package com.orama.app.dto.goal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record GoalResponseDTO(
    Long id,
    BigDecimal amount,
    String title,
    LocalDateTime createdAt,
    LocalDateTime updatedAt,
    Long clientId) {}
