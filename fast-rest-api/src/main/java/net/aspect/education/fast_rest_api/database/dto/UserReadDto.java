package net.aspect.education.fast_rest_api.database.dto;

public record UserReadDto(Long id,
                          String username,
                          String firstname,
                          String lastname,
                          String city,
                          String description) {
}
