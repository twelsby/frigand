package io.economore.frigand.gandi;

import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public class GandiAAAAUpdateRequest {

    private String rrset_type = "AAAA";
    private Integer rrset_ttl = 300;
    private List<String> rrset_values;

    public void ip(String ip) {
        rrset_values = Collections.singletonList(ip);
    }
}
