package serviciorest;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import serviciorest.servicio.WebServicePersonas;

@Component
public class JerseyConfig extends ResourceConfig 
{
    public JerseyConfig() 
    {
    	//registramos nuestra clase webService
        register(WebServicePersonas.class);
    }
}