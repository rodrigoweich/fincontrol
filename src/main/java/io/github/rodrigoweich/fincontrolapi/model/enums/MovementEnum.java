package io.github.rodrigoweich.fincontrolapi.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum MovementEnum {

    INSERT("INSERT_MOVEMENT"),
    REMOVE("REMOVE_MOVEMENT");

    private final String description;

}
