package eobrazovanje.tim6.app.security;

import java.lang.annotation.Documented;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@Documented
@AuthenticationPrincipal
public @interface CurrentUser {

}
