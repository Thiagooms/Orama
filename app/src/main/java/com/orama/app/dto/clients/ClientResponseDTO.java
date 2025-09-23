package com.orama.app.dto.clients;

import com.orama.app.enums.ClientRolesEnum;

public record ClientResponseDTO(Long id, String username, ClientRolesEnum role) {}
