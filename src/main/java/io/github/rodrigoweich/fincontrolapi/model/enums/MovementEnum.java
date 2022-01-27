package io.github.rodrigoweich.fincontrolapi.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum MovementEnum {

    INSERT("INSERT MOVEMENT"), REMOVE("REMOVE MOVEMENT");

    private String description;

}
