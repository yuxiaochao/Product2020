package com.huarui.product2020.entity.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@PropertySource("classpath:allowedLinks.properties")
public class AllowedLinks {

    @Value("#{'${hr.allowed.links}'.split(',')}")
    private List<String> linksList;
    
    @Value("#{'${hr.default.links}'.split(',')}")
    private List<String> defaultLinksList;
    

    public List<String> getLinksList() {
        return linksList;
    }

    public void setLinksList(List<String> linksList) {
        this.linksList = linksList;
    }

	public List<String> getDefaultLinksList() {
		return defaultLinksList;
	}

	public void setDefaultLinksList(List<String> defaultLinksList) {
		this.defaultLinksList = defaultLinksList;
	}
    
    
}
