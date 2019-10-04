package com.gmail.zagurskaya.service.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CityDTO {

    private Long id;
    @NotNull
    @Size(max = 50)
    private String name;
    @NotNull
    @Size(max = 150)
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
