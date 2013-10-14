package org.devdom.filter;

import com.sun.jersey.api.container.filter.UriConnegFilter;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class MediaTypeFilter extends UriConnegFilter{
    
    private static final Map<String, MediaType> mappedMediaTypes = new HashMap<String, MediaType>(2);
    
    static{
        mappedMediaTypes.put("xml", MediaType.APPLICATION_XML_TYPE );
        mappedMediaTypes.put("json", MediaType.APPLICATION_JSON_TYPE);
        mappedMediaTypes.put("html", MediaType.TEXT_HTML_TYPE);
    }
    
    public MediaTypeFilter(){
        super(mappedMediaTypes);
    }
}
