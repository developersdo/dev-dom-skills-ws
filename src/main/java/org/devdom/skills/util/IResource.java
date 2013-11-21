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
                                    "api/university",
                                    "api/university/page/:page-number",
                                    "api/university/id/:university_id",
                                    "api/category",
                                    "api/category/page/:page-number",
                                    "api/category/id/:category-id",
                                    "api/skill",
                                    "api/skill/page/:page-number",
                                    "api/skill/by/category/id/:category-id",
                                    "api/skill/by/category/id/:category-id/page/:page-number",
                                    "api/skill/id/:skill-id",
                                    "api/developer",
                                    "api/developer/page/:page-number",
                                    "api/developer/id/:developer-id",
                                    "api/developer/id/:developer-id/page/:page-number",
                                    "api/developer/where?first_name=:first-name",
                                    "api/developer/where?last_name=:last-name",
                                    "api/developer/where?sort=:sorting",
                                    "api/developer/where?limit=:top",
                                    "api/developer/where?first_name=:first-name&last_name=:last-name",
                                    "api/developer/where?first_name=:first-name&last_name=:last-name&sort=:sorting",
                                    "api/developer/where?first_name=:first-name&last_name=:last-name&sort=:sorting&limit=:top",
                                    "api/developer/by/university/id/:university_id",
                                    "api/developer/by/university/id/:university_id/page/:page-number"
                                };

    public static final String[] DESCRIPTION = {
        "Listado de universidades",
        "Listado de universidades mostrando según la página indicada",
        "Retorna la información de una universidad según su ID",
        "Lista las categorías que contienen skills de developers",
        "Lista las categorías que contienen skills de developers especificando que página se espera mostrar",
        "Retorna información sobre una categoría según su id",
        "Lista todos los skills",
        "Lista todos los skills, indicando que página se desea mostrar",
        "Retorna skills de developer según el id de una categoría",
        "Retorna skills de developer según el id de una categoría y especificando que página se quiere ver",
        "Retornar detalle de un skill",
        "Retornar el listado de developers",
        "Retornar el listado de developers, indicando la página que se desea mostrar",
        "Retorna información de un developer según su id",
        "Retorna información de un developer según su id y se especifica que página se desea mostrar",
        "Retorna el Listado de developers buscando coincidencias en el nombre",
        "Retorna el listado de developers buscando coincidencias en el apellido",
        "Retorna el listado de developers sorteando de forma ascendente o descendente",
        "Retorna el listado de developers limitando según el parámetro pasado",
        "Lista developers realizando las conbinaciones de buscar por el :first-name así como por el :last-name al mismo tiempo",
        "Lista developers realizando las conbinaciones de buscar por el :first-name así como por el :last-name al mismo tiempo y sortear los resultados usando ASC o DESC",
        "Lista developers realizando las conbinaciones de buscar por el :first-name así como por el :last-name al mismo tiempo y sortear los resultados usando ASC o DESC y limitar la cantidad de resultados utilizando :limit",
        "Listado de developers según el ID de una universidad",
        "Listado de developers según el ID de una universidad y la página a mostrar"
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
                  .replaceAll(":developer-id","1401") //developer-id = 1401
                  .replaceAll(":first-name","Melvyn")
                  .replaceAll(":last-name","P")
                  .replaceAll(":sorting","asc")
                  .replaceAll(":top","5")
                  .replaceAll(":university_id","1411");
    }

}