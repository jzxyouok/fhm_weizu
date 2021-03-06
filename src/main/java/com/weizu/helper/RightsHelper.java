package com.weizu.helper;

import com.fh.util.Tools;
import com.weizu.pojo.addressBook.WeChatAPPBean;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 * 权限计算帮助类
 */
public class RightsHelper {
	/**
	 * 利用BigInteger对权限进行2的权的和计算
	 * @param rights int型权限编码数组
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(int[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(rights[i]);
		}
		return num;
	}
	/**
	 * 利用BigInteger对权限进行2的权的和计算
	 * @param rights String型权限编码数组
	 * @return 2的权的和
	 */
	public static BigInteger sumRights(String[] rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.length; i++){
			num = num.setBit(Integer.parseInt(rights[i]));
		}
		return num;
	}

	public static BigInteger sumRights(List<String> rights){
		BigInteger num = new BigInteger("0");
		for(int i=0; i<rights.size(); i++){
			num = num.setBit(Integer.parseInt(rights.get(i)));
		}
		return num;
	}

	public static BigInteger getRights(int rights){
		BigInteger num = new BigInteger("0");
		num = num.setBit(rights);
		return num;
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,int targetRights){
		return sum.testBit(targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,int targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(String sum,String targetRights){
		if(Tools.isEmpty(sum))
			return false;
		return testRights(new BigInteger(sum),targetRights);
	}
	
	/**
	 * 测试是否具有指定编码的权限
	 * @param sum
	 * @param targetRights
	 * @return
	 */
	public static boolean testRights(BigInteger sum,String targetRights){
		return testRights(sum,Integer.parseInt(targetRights));
	}

	/**
	 * 根据经纬度判断是否有权限
	 * @return
	 */
	public static boolean hasRights(WeChatAPPBean weChatAPPBean, Double latitude, Double longitude){
		if(weChatAPPBean==null){
			return false;
		}
		if(weChatAPPBean.getName().equals("西玉曹")){
			return hasRights_XYC(latitude, longitude);
		} else if(weChatAPPBean.getName().equals("章里集")){
			return hasRights_ZLj(latitude, longitude);
		}
		return false;
	}

	/**
	 * 根据经纬度判断是否有权限--西玉曹
	 * 114.469212,36.387543  东
	 * 114.436865,36.389106  西
	 * 114.459148,36.368149  南
	 * 114.457636,36.398847  北
	 * @return
	 */
	private static boolean hasRights_XYC(Double latitude, Double longitude){
		// 在此经纬度范围内，则有权限
		if(longitude>114.436865 && longitude<114.469212 && latitude>36.368149 && latitude<36.398847){
			return true;
		}
		return false;
	}

	/**
	 * 根据经纬度判断是否有权限--章里集
	 * 114.511428,36.379393  东
	 * 114.489284,36.381881  西
	 * 114.500614,36.369304  南
	 * 114.498725,36.390173  北
	 * @return
	 */
	private static boolean hasRights_ZLj(Double latitude, Double longitude){
		// 在此经纬度范围内，则有权限
		if(longitude>114.489284 && longitude<114.511428 && latitude>36.369304 && latitude<36.390173){
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		String t = getRights(29).toString();
		System.out.println("t: "+t);
//		List<String> list = new ArrayList<String>();
//		list.add
	}
}
