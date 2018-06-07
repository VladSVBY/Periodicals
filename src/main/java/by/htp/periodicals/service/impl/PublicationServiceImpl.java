package by.htp.periodicals.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.htp.periodicals.dao.PublicationDao;
import by.htp.periodicals.domain.Publication;
import by.htp.periodicals.service.PublicationService;

@Service
public class PublicationServiceImpl implements PublicationService{
	
	@Autowired
	PublicationDao publicationDao;

	@Override
	public List<Publication> readAll() {
		return publicationDao.readAll();
	}

	@Override
	public Publication read(int id) {
		return publicationDao.read(id);
	}

}
