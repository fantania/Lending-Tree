package com.fantine.service;

import java.util.List;

import com.fantine.model.Document;

public interface DocumentService {
	
	public List<Document> getAllDocuments();
	public Document getDocumentById(int id);
	public void updateDocument(Document document);
	public void addDocument(Document document);
	public void deleteDocument(int id);

}
