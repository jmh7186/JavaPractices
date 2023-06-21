<%@page import="org.json.simple.parser.JSONParser"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="board.CurlTest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
/* CurlTest ct = new CurlTest();
ct.name = "Hong";
ct.age = 30; */
JSONObject jobj = new JSONObject();
jobj.put("name", "hong");
jobj.put("age",30);
%>
<%=jobj.toJSONString()%>