package com.orama.app.dto.goal;

import java.math.BigDecimal;

public record GoalRequestDTO(BigDecimal amount, String title, Long clientId) {}
