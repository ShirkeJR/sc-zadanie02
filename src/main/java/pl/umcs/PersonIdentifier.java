package pl.umcs;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class PersonIdentifier {

    private String firstName;
    private String surName;
    private String pesel;
}
