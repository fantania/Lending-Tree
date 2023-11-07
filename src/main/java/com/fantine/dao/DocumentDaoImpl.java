package com.fantine.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.fantine.model.Document;

@Repository
public class DocumentDaoImpl implements DocumentDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

	@Override
	@SuppressWarnings("unchecked")
	public List<Document> getAllDocuments() {
		
		List<Document> lst = getCurrentSession().createQuery("from Document").list();
		
		return lst;
	}

	@Override
	public Document getDocumentById(int id) {
		Document document = (Document) getCurrentSession().get(Document.class, id);
        return document;
	}

	@Override
	public void updateDocument(Document document) {
		
		Document documentToUpdate = getDocumentById(document.getDocumentId());
		documentToUpdate.setDocumentName(document.getDocumentName());
		
		
	}

	@Override
	public void addDocument(Document document) {
		getCurrentSession().save(document);	
		
	}

	@Override
	public void deleteDocument(int id) {
		
		Document document = getDocumentById(id);
        if (document != null)
            getCurrentSession().delete(document);
		
	}

}
