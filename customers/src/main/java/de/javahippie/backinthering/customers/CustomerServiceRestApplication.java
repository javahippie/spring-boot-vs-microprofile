package de.javahippie.backinthering.customers;

import org.eclipse.microprofile.auth.LoginConfig;

import javax.annotation.security.DeclareRoles;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 */
@ApplicationPath("/api")

@LoginConfig(authMethod = "MP-JWT", realmName = "jwt-jaspi")
@DeclareRoles({"protected"})

public class CustomerServiceRestApplication extends Application {
}
