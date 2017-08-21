package day01.beans;

@Component
public class PageObject {
    @Value("1")
	private Integer pageCurrent;

	@Override
	public String toString() {
		return "PageObject [pageCurrent=" + pageCurrent + "]";
	}
    
    
}
