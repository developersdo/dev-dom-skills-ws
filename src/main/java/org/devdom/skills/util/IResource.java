package org.devdom.skills.util;

/**
 *
 * @author Carlos Vásquez Polanco
 */
public final class IResource {
    
    private IResource(){
        throw new AssertionError();
    }

    public static final String API_PATH = "http://skills-devdom.herokuapp.com/";

    public static final String[] URI = {
                                    "api/category",
                                    "api/category/page/:page-number",
                                    "api/category/id/:category-id",
                                    "api/skill/by/category/id/:category-id",
                                    "api/skill/by/category/id/:category-id/page/:page-number",
                                    "api/skill/id/:skill-id",
                                    "api/developer",
                                    "api/developer/page/:page-number",
                                    "api/developer/id/:developer-id",
                                    "api/developer/id/:developer-id/page/:page-number"
                                };

    public static final String[] DESCRIPTION = {
        "Lista las categorías que contienen skills de developers",
        "Lista las categorías que contienen skills de developers especificando que página se espera mostrar",
        "Retorna información sobre una categoría según su id",
        "Retorna skills de developer según el id de una categoría",
        "Retorna skills de developer según el id de una categoría y especificando que página se quiere ver",
        "Retornar detalle de un skill",
        "Retornar el listado de developers",
        "Retornar el listado de developers, indicando la página que se desea mostrar",
        "Retorna información de un developer según su id",
        "Retorna información de un developer según su id y se especifica que página se desea mostrar."
    };

    public static final String getTag(String uri){
        String[] arr = uri.split("/");
        String v = "";
        for(String s : arr){
            try{
                v += s.substring(0,1);
            }catch(StringIndexOutOfBoundsException ex){}
        }
        return v.replace(":","").toLowerCase();
    }

    public static final String finalURL(String url){
        return url.replaceAll(":page-number","1")
                  .replaceAll(":category-id","5") //category-id = (5) programming language
                  .replaceAll(":skill-id","8901") //skill-id = (8901) JBoss 
                  .replaceAll(":developer-id","1401"); //developer-id = 1401
    }

}