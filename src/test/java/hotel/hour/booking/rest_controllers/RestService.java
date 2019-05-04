package hotel.hour.booking.rest_controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class RestService {

    @Autowired
    private Environment environment;


    @Value("${server.servlet.contextPath}")
    private String contextPath;

/*    @Value("${miw.admin.mobile}")
    private String adminMobile;

    @Value("${miw.admin.password}")
    private String adminPassword;*/

    private int port = 0;


    private int getPort() {
        if (this.port == 0) {
            this.port = Integer.parseInt(environment.getProperty("local.server.port"));
        }
        return this.port;
    }


    public <T> RestBuilder<T> restBuilder(RestBuilder<T> restBuilder) {
        restBuilder.port(this.getPort());
        restBuilder.path(contextPath);
      /*  if (tokenDto != null) {
            restBuilder.bearerAuth(tokenDto.getToken());
        }*/
        return restBuilder;
    }

    public RestBuilder<Object> restBuilder() {
        RestBuilder<Object> restBuilder = new RestBuilder<>(this.port);
        restBuilder.path(contextPath);
       /* if (tokenDto != null) {
            restBuilder.bearerAuth(tokenDto.getToken());
        }*/
        return restBuilder;
    }

    public RestService loginAdmin() {
     /*   if (!this.isRole(Role.ADMIN)) {
            this.tokenDto = new RestBuilder<TokenOutputDto>(this.getPort()).clazz(TokenOutputDto.class)
                    .basicAuth(this.adminMobile, this.adminPassword)
                   // .path(contextPath).path(UserResource.USERS).path(UserResource.TOKEN)
                    .post().log().build();
        }*/
        return this;
    }


    public RestService logout() {
        //  this.tokenDto = null;
        return this;
    }



/*
    public String getAdminMobile() {
        return adminMobile;
    }

    public String getAdminPassword() {
        return adminPassword;
    }*/

}
