package beans.web;

import java.io.Serializable;

/**∑÷“≥∂‘œÛ*/
public class PageObject implements Serializable{
	private static final long serialVersionUID = 1254989569142484558L;
    private int pageCount;
    private int rowCount;
    private int pageCurrent;
    private int pageSize;
    private int startIndex;
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getRowCount() {
		return rowCount;
	}
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
	public int getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(int pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
    
	
}
