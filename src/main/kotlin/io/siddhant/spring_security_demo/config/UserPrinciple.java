package io.siddhant.spring_security_demo.config;

import io.siddhant.spring_security_demo.domain.User;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;

@Getter
public class UserPrinciple implements UserDetails {

  private final User user;

  public UserPrinciple(User user) {
    this.user = user;
  }

  @Override
  @Transactional
  public Collection<? extends GrantedAuthority> getAuthorities() {
    System.out.println(user.getPassword());
    return user.getRoles().stream()
        .flatMap(
            role -> {
              // Add ROLE_ prefix for roles
              List<GrantedAuthority> roleAuthorities =
                  role.getPermissions().stream()
                      .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                      .collect(Collectors.toList());

              roleAuthorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
              return roleAuthorities.stream();
            })
        .collect(Collectors.toSet());
  }

  @Override
  public String getPassword() {
    return user.getPassword();
  }

  @Override
  public String getUsername() {
    return user.getUsername();
  }
}
