package com.songwoo.mysite.pagination;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

public class ImagePaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{
	public ImagePaginationRenderer() {
	}
	
	public void initVariables(String contextPath){
		firstPageLabel    = "<a href=\"#\" onclick=\"{0}({1});return false;\" class=\"first\">첫 페이지</a>";
        previousPageLabel = "<a href=\"#\" onclick=\"{0}({1});return false;\" class=\"prev\">이전 페이지</a>";
        currentPageLabel  = "<strong title=\"현재페이지\">{0}</strong>";
        otherPageLabel    = "<a title=\"{2} 페이지로 이동\" href=\"#\" onclick=\"{0}({1});return false; \">{2}</a>";
        nextPageLabel     = "<a href=\"#\" onclick=\"{0}({1});return false;\" class=\"next\">다음 페이지</a>";
        lastPageLabel     = "<a href=\"#\" onclick=\"{0}({1});return false;\" class=\"last\">마지막 페이지</a>";
	}

	public void setServletContext(ServletContext servletContext) {
		String contextPath = servletContext.getContextPath();
		initVariables(contextPath);
	}

}

