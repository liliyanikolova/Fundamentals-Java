package com.components;

public abstract class SystemComponent {
    private String name;
    private String type;

    protected SystemComponent(String name, String type) {
        this.setName(name);
        this.setType(type);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    protected abstract int getChangedMemory();

    protected abstract int getChangedCapacity();
}
