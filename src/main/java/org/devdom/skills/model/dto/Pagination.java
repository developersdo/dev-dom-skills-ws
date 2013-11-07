package org.devdom.skills.model.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import org.devdom.skills.util.IPagination;

/**
 *
 * @author Carlos Vásquez Polanco
 */

@Entity
@XmlRootElement
public class Pagination implements Serializable {
    
    @Id
    private int totalRows = 1;
    private int totalPages = 1;
    private int rowsPerPages = 1;
    private int positionCurrentPage;
    private int positionRowsPerPages;
    private int positionCategoryId;
    private int categoryId;
    private int resourceId;
    private Link previousPage;
    private Link currentPage;
    private Link firstPage;
    private Link nextPage;
    private Link lastPage;

    private String resourceType;
    private String absolutePath;
    private String dataType = "";   
    private String ext = "";
    
    public Pagination() {
    }
    
    public void generate(){

        if(this.dataType.contains(IPagination.DEFAULT_APPLICATION_XML)){
            setExt(IPagination.APPLICATION_XML_FILE);
        }else if(this.dataType.contains(IPagination.DEFAULT_APPLICATION_JSON)){
            setExt(IPagination.APPLICATION_JSON_FILE);
        }

        if(getTotalRows()>0){

            this.totalPages = (getTotalRows() / getRowsPerPages()) + (( (getTotalRows() % getRowsPerPages()) > 0 )?1:0);

            int previous = (getPositionCurrentPage()-1)>0?(getPositionCurrentPage()-1):1;
            int next = (getPositionCurrentPage()+1)<this.totalPages?(getPositionCurrentPage()+1):this.totalPages;
            int last = this.totalPages;
            
            //Current Page          
            this.currentPage = this.linkGenerator(1,getPositionCurrentPage(),IPagination.CAPTION_CURRENT);   
            
            //Previous Page          
            this.previousPage = this.linkGenerator(2,previous,IPagination.CAPTION_PREVIOUS);
            
            //Next Page          
            this.nextPage = this.linkGenerator(3,next,IPagination.CAPTION_NEXT);
            
            //Last Page          
            this.lastPage = this.linkGenerator(4,last,IPagination.CAPTION_LAST);
            
            //First Page
            this.firstPage = this.linkGenerator(5,1,IPagination.CAPTION_FIRST);
            
        }

    }

    private Link linkGenerator(int id, int page, String label){
        String url = getAbsolutePath();

        if(url.matches(IPagination.PATTERN_MATCH)){
            url = url.replaceAll(IPagination.PATTERN_REPLACE,"/page/"+page);
        }else if(getTotalRow()>IPagination.ROWS_PER_PAGE){
            url += "/page/"+page;
        }
        url+=getExt();
        return new Link(id,label, url, dataType);
    }

    /**
     * @return the totalRows
     */
    public int getTotalRow() {
        return getTotalRows();
    }

    public void setTotalRow(int totalRow) {
        this.setTotalRows(totalRow);
    }

    /**
     * @return the totalPages
     */
    public int getTotalPages() {
        return totalPages;
    }

    /**
     * @param totalPages the totalPages to set
     */
    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    /**
     * @return the rowsPerPages
     */
    public int getRowsPerPages() {
        return rowsPerPages;
    }

    /**
     * @param rowsPerPages the rowsPerPages to set
     */
    public void setRowsPerPages(int rowsPerPages) {
        this.rowsPerPages = rowsPerPages;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public Link getPreviousPage() {
        return previousPage;
    }

    public void setPreviousPage(Link previousPage) {
        this.previousPage = previousPage;
    }

    public Link getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Link currentPage) {
        this.currentPage = currentPage;
    }

    public Link getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(Link firstPage) {
        this.firstPage = firstPage;
    }

    public Link getNextPage() {
        return nextPage;
    }

    public void setNextPage(Link nextPage) {
        this.nextPage = nextPage;
    }

    public Link getLastPage() {
        return lastPage;
    }

    public void setLastPage(Link lastPage) {
        this.lastPage = lastPage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPositionCurrentPage() {
        return positionCurrentPage;
    }

    public void setPositionCurrentPage(int positionCurrentPage) {
        this.positionCurrentPage = positionCurrentPage;
    }

    public int getPositionRowsPerPages() {
        return positionRowsPerPages;
    }

    public void setPositionRowsPerPages(int positionRowsPerPages) {
        this.positionRowsPerPages = positionRowsPerPages;
    }

    public int getPositionCategoryId() {
        return positionCategoryId;
    }

    public void setPositionCategoryId(int positionCategoryId) {
        this.positionCategoryId = positionCategoryId;
    }

    public String getResourceType() {
        return resourceType;
    }


    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    public String getAbsolutePath() {
        return absolutePath;
    }

    public void setAbsolutePath(String absolutePath) {
        this.absolutePath = absolutePath;
    }

    /**
     * @return the resourceId
     */
    public int getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId the resourceId to set
     */
    public void setResourceId(int resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * @return the ext
     */
    public String getExt() {
        return ext;
    }

    /**
     * @param ext the ext to set
     */
    public void setExt(String ext) {
        this.ext = ext;
    }
    
}

@XmlRootElement
class Link implements Serializable{
    
    @Id
    private int id = 0;
    private String label = "";
    private String url = "";
    private String dataType = "";

    public Link(){
    
    }
    
    public Link(int id,String label, String url, String dataType){
        this.id = id;
        this.label = label;
        this.url = url;
        this.dataType = dataType;
    }
    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the dataType
     */
    public String getDataType() {
        return dataType;
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

}