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
    private int totalRow = 1;
    private int totalPages = 1;
    private int previousPage = 1;
    private int currentPage = 1;
    private int firstPage = 1;
    private int nextPage = 1;
    private int lastPage = 1;
    private int rowsPerPages = 1;

    
    public Pagination() {
    }
    
    public Pagination(int currentPage, int rowsPerPages, int size){
        if(size>0){
            this.rowsPerPages = rowsPerPages;
            this.currentPage = currentPage;
            this.totalRow = size;
            this.totalPages = (this.totalRow / this.rowsPerPages) + (( (this.totalRow % this.rowsPerPages) > 0 )?1:0);
            this.previousPage = (this.currentPage-1)>0?(this.currentPage-1):1;
            this.nextPage = (this.currentPage+1)<this.totalPages?(this.currentPage+1):this.totalPages;
            this.lastPage = this.totalPages;
            this.firstPage=1;
        }
    }

    /**
     * @return the totalRow
     */
    public int getTotalRow() {
        return totalRow;
    }

    /**
     * @param totalRow the totalRow to set
     */
    public void setTotalRow(int totalRow) {
        this.totalRow = totalRow;
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
     * @return the previousPage
     */
    public int getPreviousPage() {
        return previousPage;
    }

    /**
     * @param previousPage the previousPage to set
     */
    public void setPreviousPage(int previousPage) {
        this.previousPage = previousPage;
    }

    /**
     * @return the currentPage
     */
    public int getCurrentPage() {
        return currentPage;
    }

    /**
     * @param currentPage the currentPage to set
     */
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    /**
     * @return the firstPage
     */
    public int getFirstPage() {
        return firstPage;
    }

    /**
     * @param firstPage the firstPage to set
     */
    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }

    /**
     * @return the nextPage
     */
    public int getNextPage() {
        return nextPage;
    }

    /**
     * @param nextPage the nextPage to set
     */
    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    /**
     * @return the lastPage
     */
    public int getLastPage() {
        return lastPage;
    }

    /**
     * @param lastPage the lastPage to set
     */
    public void setLastPage(int lastPage) {
        this.lastPage = lastPage;
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
    
}
