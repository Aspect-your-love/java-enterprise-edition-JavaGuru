package net.aspect.education.http.rest;

import lombok.extern.slf4j.Slf4j;
import net.aspect.education.database.dto.PageResponse;
import net.aspect.education.database.dto.UserCreateEditDto;
import net.aspect.education.database.dto.UserFilter;
import net.aspect.education.database.dto.UserReadDto;
import net.aspect.education.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.ResponseEntity.notFound;


@Slf4j
@RequestMapping("/api/v1/users")
@RestController
public class UserRestController {
    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public PageResponse<UserReadDto> findAll(UserFilter filter, Pageable pageable) {
        Page<UserReadDto> page = userService.findAll(filter, pageable);

        return PageResponse.of(page);
    }

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable("id") Long id) {
        return userService.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@Validated @RequestBody UserCreateEditDto user) {
        UserReadDto dto = userService.create(user);
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable("id") Long id,
                         @Validated @RequestBody UserCreateEditDto userDto) {

        return userService.update(id, userDto).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        if (!userService.delete(id))
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    /*@GetMapping(
            value = "/{id}/avatar",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public byte[] findAvatar(@PathVariable("id") Long id) {
        return userService.findAvatar(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }*/

    @GetMapping(value="{id}/avatar")
    public ResponseEntity<byte[]> findAvatar(@PathVariable("id") Long id) {
        return userService.findAvatar(id)
                .map(content -> ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE)
                        .contentLength(content.length)
                        .body(content))
                .orElseGet(notFound()::build);
    }
}
