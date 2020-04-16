package org.keycloak.forms.login;

import org.keycloak.Config;
import org.keycloak.forms.login.freemarker.AnlFreeMarkerLoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.KeycloakSessionFactory;
import org.keycloak.theme.FreeMarkerUtil;

/**
 * @commentedBy dariosarcevic 15/04/2020
 */
public class AnlLoginFormsProviderFactory implements LoginFormsProviderFactory {

    private FreeMarkerUtil freeMarker;

    @Override
    public LoginFormsProvider create(KeycloakSession session) {
        return new AnlFreeMarkerLoginFormsProvider(session, freeMarker);
    }

    @Override
    public void init(Config.Scope config) {
        this.freeMarker = new FreeMarkerUtil();
    }

    @Override
    public void postInit(KeycloakSessionFactory keycloakSessionFactory) { }

    @Override
    public void close() { }

    @Override
    public String getId() {
        return "freemarker";
    }
}
