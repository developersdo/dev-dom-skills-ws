package org.devdom.model.dto;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;


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
    private String dataType = "";
    private int categoryId;

    private Link previousPage;
    private Link currentPage;
    private Link firstPage;
    private Link nextPage;
    private Link lastPage;
    
    
    
    public Pagination() {
    }
    
    public Pagination(int currentPage, int rowsPerPages, int categoryId,int size, String dataType){

        String ext = "";
        String url = "";
        String[] labels = {""};
        
        if(dataType.contains("application/xml")){
            ext = ".xml";
        }else if(dataType.contains("application/json")){
            ext = ".json";
        }
        this.categoryId = categoryId;
        if(size>0){
            this.rowsPerPages = rowsPerPages;
            this.totalRows = size;
            this.totalPages = (this.totalRows / this.rowsPerPages) + (( (this.totalRows % this.rowsPerPages) > 0 )?1:0);
            
            int previous = (currentPage-1)>0?(currentPage-1):1;
            int next = (currentPage+1)<this.totalPages?(currentPage+1):this.totalPages;
            int last = this.totalPages;
            
            //Current Page          
            this.currentPage = this.linkGenerator(1,categoryId,currentPage,"Current Page", ext);   
            
            //Previous Page          
            this.previousPage = this.linkGenerator(2,categoryId,previous,"Previous Page", ext);
            
            //Next Page          
            this.nextPage = this.linkGenerator(3,categoryId,next,"Next Page", ext);
            
            //Last Page          
            this.lastPage = this.linkGenerator(4,categoryId,last,"Last Page", ext);
            
            //First Page
            this.firstPage = this.linkGenerator(5,categoryId,1,"First Page", ext);
            
        }
    }
    
    private Link linkGenerator(int id, int categoryId, int page, String label, String ext){
        String url = "/api/skill/by/category/id/"+categoryId+"/page/"+page+ext;           
        return new Link(id,label, url, dataType); 
    }
    
    /**
     * @return the totalRows
     */
    public int getTotalRow() {
        return totalRows;
    }

    /**
     * @param totalRows the totalRows to set
     */
    public void setTotalRow(int totalRow) {
        this.totalRows = totalRow;
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
     * @param dateType the dataType to set
     */
    public void setDateType(String dataType) {
        this.setDataType(dataType);
    }

    /**
     * @param dataType the dataType to set
     */
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    /**
     * @return the previousPage
     */
    public Link getPreviousPage() {
        return previousPage;
    }

    /**
     * @param previousPage the previousPage to set
     */
    public void setPreviousPage(Link previousPage) {
        this.previousPage = previousPage;
    }

    /**
     * @return the currentPage
     */
    public Link getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(Link currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the firstPage
     */
    public Link getFirstPage() {
        return firstPage;
    }

    /**
     * @param firstPage the firstPage to set
     */
    public void setFirstPage(Link firstPage) {
        this.firstPage = firstPage;
    }

    /**
     * @return the nextPage
     */
    public Link getNextPage() {
        return nextPage;
    }

    /**
     * @param nextPage the nextPage to set
     */
    public void setNextPage(Link nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @return the lastPage
     */
    public Link getLastPage() {
        return lastPage;
    }

    /**
     * @param lastPage the lastPage to set
     */
    public void setLastPage(Link lastPage) {
        this.lastPage = lastPage;
    }

    /**
     * @return the categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * @param categoryId the categoryId to set
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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