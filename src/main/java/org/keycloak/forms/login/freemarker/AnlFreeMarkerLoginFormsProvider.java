package org.keycloak.forms.login.freemarker;

import org.keycloak.forms.login.LoginFormsPages;
import org.keycloak.forms.login.LoginFormsProvider;
import org.keycloak.models.KeycloakSession;
import org.keycloak.theme.FreeMarkerUtil;
import org.keycloak.theme.Theme;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriBuilder;
import java.util.Locale;
import java.util.Properties;

/**
 * @commentedBy dariosarcevic 15/04/2020
 */
public class AnlFreeMarkerLoginFormsProvider extends FreeMarkerLoginFormsProvider implements LoginFormsProvider {

    public AnlFreeMarkerLoginFormsProvider(KeycloakSession session, FreeMarkerUtil freeMarker) {
        super(session, freeMarker);
    }

    @Override
    protected void createCommonAttributes(Theme theme, Locale locale, Properties messagesBundle, UriBuilder baseUriBuilder, LoginFormsPages page) {
        super.createCommonAttributes(theme, locale, messagesBundle, baseUriBuilder, page);
        MultivaluedMap<String, String> queryParameters = uriInfo.getQueryParameters();
        if (queryParameters != null) {
            String redirectUri = queryParameters.getFirst("redirect_uri");
            attributes.put("redirectUri", redirectUri);
        }
    }


}
