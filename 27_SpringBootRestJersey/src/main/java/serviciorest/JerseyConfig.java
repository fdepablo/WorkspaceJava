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
        //Si quisieramos registrar otros servicios o cambiar el de arriba
        //podriamos hacer varios register
        //register(OtroServicioDistinto.class);
    }
}