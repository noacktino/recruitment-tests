package com.asideas.recruitmenttests.newsapp.pojo;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class is a POJO container which is used to transfer the data. This class
 * is minor documented since it only contains getter and setter methods.
 * 
 * @author Tino
 *
 */
@XmlRootElement
public class NewsPojo {
	
	private UUID id;
	private String header;
	private String shortDescription;
	private String text;
	private Date publishDate;
	private Set<String> authors;
	private Set<String> keywords;
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getHeader() {
		return header;
	}
	
	public void setHeader(String header) {
		this.header = header;
	}
	
	public String getShortDescription() {
		return shortDescription;
	}
	
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getPublishDate() {
		return publishDate;
	}
	
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	
	public Set<String> getAuthors() {
		return authors;
	}
	
	public void setAuthors(Set<String> authors) {
		this.authors = authors;
	}
	
	public Set<String> getKeywords() {
		return keywords;
	}
	
	public void setKeywords(Set<String> keywords) {
		this.keywords = keywords;
	}
}
