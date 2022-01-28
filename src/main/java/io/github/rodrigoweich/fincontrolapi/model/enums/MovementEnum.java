package io.github.rodrigoweich.fincontrolapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MovementEnum {

    INSERT("INSERT_MOVEMENT"),
    REMOVE("REMOVE_MOVEMENT");

    private final String description;

}
