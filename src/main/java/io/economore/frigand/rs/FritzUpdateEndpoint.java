package io.economore.frigand.rs;

import io.economore.frigand.gandi.GandiAUpdateRequest;
import io.economore.frigand.gandi.GandiAAAAUpdateRequest;
import io.economore.frigand.gandi.GandiAnswer;
import io.economore.frigand.gandi.GandiClient;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/update")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component
public class FritzUpdateEndpoint {

    @NonNull
    private GandiClient client;
    
    @Value("${frigand.target}")
    private String name;

    @Path("/")
    @GET
    @Produces("text/plain")
    public Response update(@QueryParam("ipaddr") String ipaddr, @QueryParam("username") String username, @QueryParam("pass") String pass,
                           @QueryParam("domain") String domain, @QueryParam("ip6addr") String ip6ddr) {
        for (String n : name.split("[:;,]")) {
//            GandiAUpdateRequest request = new GandiAUpdateRequest();
//            request.ip(ipaddr);
//            GandiAnswer answer = client.update(domain, n, "A", username, request);
//            if(!"DNS Record Created".equals(answer.getMessage())) {
//                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
//            }

            GandiAAAAUpdateRequest request6 = new GandiAAAAUpdateRequest();
            request6.ip(ip6addr);
            GandiAnswer answer6 = client.update(domain, n, "AAAA", username, request6);
            if(!"DNS Record Created".equals(answer.getMessage())) {
                return Response.status(Response.Status.NOT_ACCEPTABLE).build();
            }
        }

        return Response.ok().build();
    }

}
