package com.pcg.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import com.pcg.search.utils.QueryParameters;

/**
 * 
 * @author oonyimadu
 *
 */
public class Cleaner 
{
	public static String[] splitUnderscore(String string)
	{
		String[] splitString = string.split("_");
		return splitString;
	}
	
	public static List<String> mergeListForFiler(String filterType, String[] array)
	{
		List<String> mergerList = null;
		if(array.length>0)
		{
			mergerList = new ArrayList<String>();
			for(String arr:array)
			{
				arr = StringUtils.normalizeSpace(arr);
				arr = filterType+":"+arr;
				mergerList.add(arr);
			}
		}
		return mergerList;
		
	}
	
	/**
	 * 
	 * @param filters
	 * @return String 
	 */
	public static String createFilterParam(List<String> filters)
	{
		String filterParam = null;
		if(CollectionUtils.isNotEmpty(filters))
		{
			int fsize = filters.size();
			if(fsize == 1)
			{
				filterParam = filters.get(0);
			}
			else if(fsize > 1)
			{
				filterParam = "";
				for(int i=0;i<fsize;i++)
				{
					if(i!=fsize-1)
					{
						filterParam = filterParam +filters.get(i)+" AND ";
					}
					else if(i==fsize-1)
					{
						filterParam = filterParam+filters.get(i);
					}
				}
			}
		}
		return filterParam;
	}
	
	public static List<String> createFilterForTypeOfCare(List<String> filters)
	{
		String filterParam = null;
		if(CollectionUtils.isNotEmpty(filters))
		{
			int fsize = filters.size();
			if(fsize == 1)
			{
				filterParam = filters.get(0);
			}
			else if(fsize > 1)
			{
				filterParam = "(";
				for(int i=0;i<fsize;i++)
				{
					if(i!=fsize-1)
					{
						filterParam = filterParam +filters.get(i)+" OR ";
					}
					else if(i==fsize-1)
					{
						filterParam = filterParam+filters.get(i);
					}
				}
				filterParam = filterParam+")";
			}
		}
		List<String> tcList = new ArrayList<String>();
		tcList.add(filterParam);
		return tcList;
	}
	
	public static Boolean checkParams(QueryParameters qp, String type, String[] splitString)
	{
		Map<String, List<String>> qmap = qp.getQParams();
		Boolean fans = true;
		List<String> cString = new ArrayList<String>();
		if(type.equals("careprovided"))
		{
			cString = qmap.get("cp");
			
		}
		else if(type.equals("admissions"))
		{
			cString = qmap.get("ad");
		}
		else if(type.equals("typeOfCareHome"))
		{
			cString = qmap.get("tc");
		}
		
		for(String s:splitString)
		{
			if(!cString.contains(s))
			{
				fans =  false;
				break;
			}
		}
		return fans;
		
		/**
		 * 
		 * <entry key="cp"> <!-- Care Provided -->
					<list>
						<value>de</value><!-- Dementia -->
						<value>mhc</value><!-- Mental Health Conditions-->
						<value>ld</value><!-- Learning Disabilities -->
						<value>oa</value><!-- Old Age -->
						<value>pd</value><!-- Physical Disabilities -->
						<value>si</value><!-- Sensory Impairments -->
						<value>ppa</value><!-- Past or present alcohol dependence  -->
						<value>ppd</value><!-- Past or present drug dependence  -->
			
					</list>
				</entry>
				<entry key="ad"><!-- Admissions -->
					<list>
						<value>ss</value><!-- short stay -->
						<value>fd</value><!-- formal daycare-->
						<value>ifd</value><!-- informal day care  -->
						<value>ls</value><!-- long stay  -->
						
					</list>
				</entry>
				<entry key="tc"><!-- Type of care home -->
					<list>
						<value>chwtn</value><!-- Care Home without nursing -->
						<value>chwn</value><!-- Care Home with nursing -->
						<value>chb</value><!-- Care Home offering both types of care -->
						
						
					</list>
		 */
		
	}
	
	/**
	public static void main(String[] args)
	{
		//String s = "de_mhc_ld_oa_pd_si_ppad_ppdd";
		String s = "de";
		String[] a = Cleaner.splitUnderscore(s);
		System.out.println(a.length);
		for(String ss:a)
		{
			System.out.println(ss);
		}
			
	}
	*/
	
}
