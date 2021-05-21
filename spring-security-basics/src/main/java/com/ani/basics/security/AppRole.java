package com.ani.basics.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum AppRole {
    MACHINE(Set.of(AppPermission.MACHINE_ON, AppPermission.MACHINE_OFF)),
    WORKER(Set.of(AppPermission.WORKER_LOGIN, AppPermission.WORKER_LOGOUT)),
    WORKER_MACHINE( Set.of(AppPermission.MACHINE_WORKER_PAUSE) );

    private final Set<AppPermission> permissions;

    AppRole(Set<AppPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<AppPermission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> grantedAuthorities() {
        var authorities = getPermissions().stream().map(
                permission -> new SimpleGrantedAuthority(permission.getPermission())
        ).collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
