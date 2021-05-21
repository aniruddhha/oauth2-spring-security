package com.ani.basics.security;

public enum AppPermission {
    MACHINE_ON("machine:on"),
    MACHINE_OFF("machine:off"),

    WORKER_LOGIN("worker:login"),
    WORKER_LOGOUT("worker:logout"),

    MACHINE_WORKER_PAUSE("machine:worker:pause");

    private final String permission;

    AppPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
