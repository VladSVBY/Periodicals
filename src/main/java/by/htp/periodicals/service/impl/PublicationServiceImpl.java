package by.htp.periodicals.service.impl;

import by.htp.periodicals.dao.PublicationDao;
import by.htp.periodicals.service.PublicationService;

public class PublicationServiceImpl implements PublicationService {
	
	private PublicationDao publicationDao;

	public void setPublicationDao(PublicationDao publicationDao) {
		this.publicationDao = publicationDao;
	}

}
