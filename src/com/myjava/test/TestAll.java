package com.myjava.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.myjava.logic.ArticleLogic;

public class TestAll {

	//测试业务逻辑
	@Test
	public void testGetArticleTitle() {
		String title = ArticleLogic.getArticleTitle("1");
		Assert.assertNotNull("get article title error.", title);
	}
	
	//使用gson解析json
	@Test
	public void testJson() {
		String jsonString = "{a:1, b:'b'}";
		JsonParser jsonParser = new JsonParser();
		JsonObject object = (JsonObject)jsonParser.parse(jsonString);
		Assert.assertEquals(object.get("a").getAsInt(), 1);
		Assert.assertNotNull(object.get("b").getAsString(), "b");
	}

}
