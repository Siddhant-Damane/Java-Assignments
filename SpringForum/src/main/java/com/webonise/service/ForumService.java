package com.webonise.service;

import java.util.ArrayList;
import java.util.HashMap;

public interface ForumService {

	public HashMap<String, ArrayList<String>> getFullMap();
	public void setmap() ;
	public void login();
	public void logout();
	public boolean isLogin();

}

