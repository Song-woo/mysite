package com.songwoo.mysite.pagination;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.songwoo.mysite.o2oband.property.PropertyService;

@Component
public class ServiceUtil {
	
	@Resource(name = "propertiesService")
	protected PropertyService propertiesService;
	
    /**
     * 페이징정보를 셋팅한다.
     * 
     * @param paginationInfo
     * @param paggingVO
     * @param pageUnit
     * @param pageSize
     */
    public PaginationInfo getMappingPaginationInfoToParamEachOther(int pageUnit, int pageSize, int totCnt, Pagenation pagenationParam){
		
    	/** pageing **/
    	PaginationInfo paginationInfo = new PaginationInfo();
	
		paginationInfo.setCurrentPageNo(pagenationParam.getCurrentPageNo());
		paginationInfo.setRecordCountPerPage(pageUnit);
		paginationInfo.setPageSize(pageSize);

        paginationInfo.setTotalRecordCount(totCnt);
        
        pagenationParam.setFirstIndex(paginationInfo.getFirstRecordIndex());
        pagenationParam.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        
        return paginationInfo;
    }
    
    public PaginationInfo getMappingPaginationInfoToParamEachOther(int totCnt, Pagenation pagenationParam){
    	return getMappingPaginationInfoToParamEachOther(propertiesService.getInt("recordCountPerPage"), propertiesService.getInt("pageSize"), totCnt, pagenationParam);
    }

}
