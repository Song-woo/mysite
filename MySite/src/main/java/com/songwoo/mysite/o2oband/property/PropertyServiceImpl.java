package com.songwoo.mysite.o2oband.property;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyServiceImpl implements PropertyService{

    private Map<String, String> properties;
    
	private final Logger logger = LoggerFactory.getLogger(PropertyServiceImpl.class);
	
    /**
     * properties를 지정할 때 Attribute로 정의
     * @param properties
     */
    public void setProperties(Map<String, String> properties) {
        this.properties = properties;
    }

	@Override
	public int getInt(String key) {
		return Integer.parseInt(properties.get(key));
	}

	@Override
	public String getString(String key) {
		return properties.get(key);
	}
	
	@Override
	public boolean getBoolean(String key) {
		
		return Boolean.parseBoolean(properties.get(key));
	}
}