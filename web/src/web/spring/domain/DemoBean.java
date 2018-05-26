package web.spring.domain;

public class DemoBean {
	private String content;
	
	private String jdbcUrl;
	private String BookNeme;
	public DemoBean( ) {
	}
	public DemoBean(String content) {
		super();
		this.content = content;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getJdbcUrl() {
		return jdbcUrl;
	}
	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
	public String getBookNeme() {
		return BookNeme;
	}
	public void setBookNeme(String bookNeme) {
		BookNeme = bookNeme;
	}
	
}
