package com.asideas.recruitmenttests.newsapp.db;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.asideas.recruitmenttests.newsapp.pojo.NewsPojo;

public class NewsDatabase {
	
	private static Set<NewsPojo> database = new HashSet<NewsPojo>();
	
	private static UUID insert(NewsPojo pojo) {
		return null;
	}
	
	private static boolean delete(UUID id) {
		return false;
	}
	
	private static boolean update(NewsPojo pojo) {
		return false;
	}

}
