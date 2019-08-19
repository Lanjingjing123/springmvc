package com.csii.ljj;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getProductRequest", propOrder = {
        "SecretKey",
        "Type",
        "ProductIDs"
})
public class GetProductRequest {
    @XmlElement(name = "SecretKey")
    private String SecretKey;
    @XmlElement(name = "Type")
    private Integer Type;
    @XmlElementWrapper(name="ProductIDs")
    @XmlElement(name="ProductID")
    private List<String> ProductIDs;
    public String getSecretKey() {
        return SecretKey;
    }
    public void setSecretKey(String secretKey) {
        SecretKey = secretKey;
    }
    public Integer getType() {
        return Type;
    }
    public void setType(Integer type) {
        Type = type;
    }
    public List<String> getProductIDs() {
        return ProductIDs;
    }
    public void setProductIDs(List<String> productIDs) {
        ProductIDs = productIDs;
    }
}

