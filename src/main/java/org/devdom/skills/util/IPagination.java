package org.devdom.skills.util;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public class IPagination {
    
    private IPagination(){
        throw new AssertionError();
    }

    public static final String PATTERN_REPLACE = "/page/+(\\d)*";

    public static final String PATTERN_MATCH = "(?s).*\\/page/.*";
    
    public static final String APPLICATION_JSON_FILE = ".json";
    
    public static final String APPLICATION_XML_FILE = ".xml";
    
    public static final String DEFAULT_APPLICATION_XML = "application/xml";
    
    public static final String DEFAULT_APPLICATION_JSON = "application/json";
    
    public static final String CAPTION_CURRENT = "Current page";
    
    public static final String CAPTION_PREVIOUS = "Previous Page";

    public static final String CAPTION_NEXT = "Next Page";
    
    public static final String CAPTION_LAST = "Last Page";
    
    public static final String CAPTION_FIRST = "First Page";
    
    public static final int ROWS_PER_PAGE = 10;
    
}
