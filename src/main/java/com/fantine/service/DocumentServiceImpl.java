package com.fantine.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fantine.dao.DocumentDao;
import com.fantine.model.Document;

@Service
@Transactional
public class DocumentServiceImpl implements DocumentService {
	
	@Autowired
	private DocumentDao documentDao;
	

	@Override
	public List<Document> getAllDocuments() {
		List<Document> lst = documentDao.getAllDocuments();
		
		return lst;
		
	}

	@Override
	public Document getDocumentById(int id) {
		Document document = documentDao.getDocumentById(id);
		
		return document;
	}

	@Override
	public void updateDocument(Document document) {
		documentDao.updateDocument(document);
		
	}

	@Override
	public void addDocument(Document document) {
		documentDao.addDocument(document);
		
	}

	@Override
	public void deleteDocument(int id) {
		documentDao.deleteDocument(id);
		
	}

}
