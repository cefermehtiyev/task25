package az.ingress.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CacheData implements Serializable {
    private final static Long serialVersionUID = 1L;
    private String name;
}
