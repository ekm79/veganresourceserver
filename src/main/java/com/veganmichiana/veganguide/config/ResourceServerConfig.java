package com.veganmichiana.veganguide.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter
{

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources)
    {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception
    {
        http.
                anonymous().disable()
                .authorizeRequests()
                .antMatchers("/admin/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .antMatchers("/restaurants/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .antMatchers("/menuitems/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .antMatchers("/products/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .antMatchers("/stores/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .antMatchers("/search/**").access("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}