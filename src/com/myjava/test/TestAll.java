package com.myjava.test;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

import com.myjava.logic.ArticleLogic;

public class TestAll {

	@Test
	public void testGetArticleTitle() {
		String title = ArticleLogic.getArticleTitle("1");
		Assert.assertNotNull("get article title error.", title);
	}

}
